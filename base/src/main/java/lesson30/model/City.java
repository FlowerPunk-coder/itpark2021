package lesson30.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rus_city_name", nullable = false)
    private String russianName;
    @Column(name = "en_city_name", nullable = false)
    private String englishName;
    @Column(unique = true)
    private int code;
    @Column
    private long population;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    public City(String russianName, String englishName, int code, long population, Country country) {
        this.russianName = russianName;
        this.englishName = englishName;
        this.code = code;
        this.population = population;
        this.country = country;
    }

    public String toString() {
        return this.getCountry().getCode() + " " +this.getRussianName() + " " + this.getEnglishName() + " " + this.getCode()
                + " " + this.getPopulation();
    }
}
