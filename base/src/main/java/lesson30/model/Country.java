package lesson30.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_code")
    private String code;
    @Column(name = "rus_country_name", nullable = false)
    private String russianName;
    @Column(name = "en_country_name", nullable = false)
    private String englishName;
    @OneToMany(mappedBy = "country")
    private List<City> city;

    public Country(String code, String russianName, String englishName) {
        this.code = code;
        this.russianName = russianName;
        this.englishName = englishName;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public String toString() {
        return this.getCode() + " " + this.getRussianName() + " " + this.getEnglishName();
    }
}
