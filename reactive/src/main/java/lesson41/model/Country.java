package lesson41.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "country")
public class Country {

    @Id
    private String code;

    private String russianName;

    private String englishName;


    public Country(String code, String russianName, String englishName) {
        this.code = code;
        this.russianName = russianName;
        this.englishName = englishName;
    }


    public String toString() {
        return this.getCode() + " " + this.getRussianName() + " " + this.getEnglishName();
    }
}
