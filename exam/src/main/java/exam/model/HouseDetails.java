package exam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "house_details")
public class HouseDetails {

    @Id
    private long id;
    @Column(name = "systems", nullable = false)
    private int numberOfSystems;
    @Column(name = "entrances", nullable = false)
    private int numberOfEntrances;
    @Column(name = "levels", nullable = false)
    private int numberOfLevels;
    @Column(name = "multilevel", nullable = false)
    private boolean multilevel;
    @Column(name = "comment")
    private String comment;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private House house;

    @OneToMany(mappedBy = "houseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Entrance> entrances;


}
