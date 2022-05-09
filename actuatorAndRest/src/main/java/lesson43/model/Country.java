package lesson43.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    @NotEmpty
    @Column(name = "country_code", nullable = false, unique = true)
    private String code;

    @Column(name = "rus_country_name", nullable = false)
    private String russianName;

    @Column(name = "en_country_name", nullable = false)
    private String englishName;
}
