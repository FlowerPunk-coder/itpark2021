package lesson24.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String isbn;
    private String title;
    private Integer pages;
    private BigDecimal price;
    private Author author;

    public Book(String isbn, String title, Integer pages, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.price = price;
    }
}
