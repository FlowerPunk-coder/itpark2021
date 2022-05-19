package exam.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int number;
    @ColumnDefault(value = "")
    private String sing;
    private int prefix = 0;
    @Column(nullable = false)
    private boolean checked;
    @Column(name = "check_date")
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;
    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    private HouseDetails houseDetails;
}
