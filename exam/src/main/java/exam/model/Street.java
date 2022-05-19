package exam.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private List<House> houses;
}
