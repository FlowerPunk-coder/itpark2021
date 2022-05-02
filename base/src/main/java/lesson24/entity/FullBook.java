package lesson24.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullBook {

    private String isbn;
    private String title;
    private String author;
    private Integer pages;
    private BigDecimal price;
}
