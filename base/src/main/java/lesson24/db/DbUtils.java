package lesson24.db;

import lesson24.BooksRunner;
import lesson24.entity.Author;
import lesson24.entity.Book;
import lesson24.entity.FullBook;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@UtilityClass
public class DbUtils {

    private final Properties DB_PROP = new Properties();

    static {
        try {
            DB_PROP.load(BooksRunner.class.getResourceAsStream("/db.properties"));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SneakyThrows(SQLException.class)
    public void dropTableFromDb() {
        try (final Connection connection = getConnection();
            final PreparedStatement dropBooks = connection.prepareStatement("DROP TABLE if EXISTS books");
            final PreparedStatement dropAuthors = connection.prepareStatement("DROP TABLE if EXISTS authors"))
        {
            dropBooks.execute();
            dropAuthors.execute();
        }
    }

    public void createTable() {
        try (final Connection connection = getConnection();
            final PreparedStatement createAuthors = connection.prepareStatement(
                    """
                    CREATE TABLE authors
                    (id int AUTO_INCREMENT, 
                    name VARCHAR(100) NOT NULL UNIQUE,
                    CONSTRAINT authors_pk 
                        PRIMARY KEY (id));
                    """
            );

            final PreparedStatement createBooks = connection.prepareStatement("""
                    CREATE TABLE books(
                    id int AUTO_INCREMENT,
                    isbn VARCHAR(17) NOT NULL UNIQUE,
                    title VARCHAR(100) NOT NULL,
                    price NUMERIC NULL,
                    pages int NULL,
                    author_id int NULL,
                    CONSTRAINT books_pk
                        PRIMARY KEY (id),
                    CONSTRAINT books_authors_fk
                        FOREIGN KEY (author_id) REFERENCES authors (id));
                    """))
        {
            createAuthors.execute();
            createBooks.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SneakyThrows(SQLException.class)
    public Integer insertAuthor(Author author) {
        final String authorName = author.getName();
        if (authorName.equals("")) {
            return -1;
        }
        try(final Connection connection = getConnection();
            final PreparedStatement insertAuthor = connection.prepareStatement("INSERT INTO authors(name) VALUES(?)");
            final PreparedStatement getAuthorId = connection.prepareStatement("SELECT id FROM authors WHERE name = ?"))
        {
            insertAuthor.setString(1, authorName);
            insertAuthor.execute();
            getAuthorId.setString(1, authorName);
            final ResultSet resultSet = getAuthorId.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

    @SneakyThrows(SQLException.class)
    public void insertBook(int authorId, Book book) {
        try(final Connection connection = getConnection();
        final PreparedStatement insertFullBook = connection.prepareStatement("""
                INSERT INTO books(isbn, title, price, pages, author_id)
                VALUES (?, ?, ?, ?, ?)
                """);
        final PreparedStatement insertBook = connection.prepareStatement("""
                INSERT INTO books(isbn, title, price, pages)
                VALUES (?, ?, ?, ?)
                """))
        {
            if (authorId > 0) {
                insertFullBook.setString(1, book.getIsbn());
                insertFullBook.setString(2, book.getTitle());
                insertFullBook.setBigDecimal(3, book.getPrice());
                insertFullBook.setInt(4, book.getPages());
                insertFullBook.setInt(5, authorId);
                insertFullBook.execute();
            } else {
                insertBook.setString(1, book.getIsbn());
                insertBook.setString(2, book.getTitle());
                insertBook.setBigDecimal(3, book.getPrice());
                insertBook.setInt(4, book.getPages());
                insertBook.execute();
            }
        }
    }

    @SneakyThrows(SQLException.class)
    public List<FullBook> searchBookLikeTitleOrAuthor(String text) {
        try(final Connection connection = getConnection();
            final PreparedStatement searchStatement = connection.prepareStatement("""
                select b.isbn, b.title, b.price, b.pages, a.name from books b
                left join authors a
                on b.author_id = a.id
                where lower(b.title) like ? or lower(a.name) like ?
                order by b.id
            """)
        ) {
            searchStatement.setString(1, "%" + text + "%");
            searchStatement.setString(2, "%" + text + "%");
            final ResultSet resultSet = searchStatement.executeQuery();
            List<FullBook> result = new ArrayList<>();
            while(resultSet.next()) {
                result.add(new FullBook(
                        resultSet.getString("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.wasNull() ? null : resultSet.getInt("pages"),
                        resultSet.getBigDecimal("price")));
            }
            return result;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_PROP.getProperty("jdbc.url"),
                DB_PROP.getProperty("db.login"),
                DB_PROP.getProperty("db.password"));
    }
}
