package lesson24.csv;

import lesson24.BooksRunner;
import lesson24.entity.Author;
import lesson24.entity.FullBook;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class CsvRunner {

    public List<FullBook> getBookFromResources() {
        List<FullBook> books = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader
                ((Objects.requireNonNull(BooksRunner.class.getResourceAsStream("/books.csv"))))))
        {
           while (reader.ready()) {
               String[] tempLine = reader.readLine().split(",");
               FullBook book = new FullBook();
               book.setIsbn(tempLine[0].trim());
               book.setTitle(tempLine[1].trim());
               book.setAuthor(tempLine[2].trim());
               book.setPages(Integer.parseInt(tempLine[3].trim()));
               book.setPrice(new BigDecimal(tempLine[4].trim()));
               books.add(book);
           }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return books;
    }
}
