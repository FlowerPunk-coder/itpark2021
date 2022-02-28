package lesson24;


import lesson24.csv.CsvRunner;
import lesson24.db.DbUtils;
import lesson24.entity.Author;
import lesson24.entity.Book;


public class BooksRunner {


    public static void main(String[] args) {
        DbUtils.dropTableFromDb();
        DbUtils.createTable();
        CsvRunner.getBookFromResources().forEach(fullBook -> {
            Author author = new Author(fullBook.getAuthor());
            Book book = new Book(fullBook.getIsbn(),
                    fullBook.getTitle(), fullBook.getPages(),
                    fullBook.getPrice(), author);

            int id = DbUtils.insertAuthor(author);
            DbUtils.insertBook(id, book);
        });
    }

}
