package exam.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "house")
public class House {
    @Id
    private Long id;
    @Column(nullable = false)
    private int number;
    private String sing;
    private int prefix;
    @Column(name = "check", nullable = false)
    private boolean hasChecked;
    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;


}
