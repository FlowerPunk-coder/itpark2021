package exam.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "entrance")
public class Entrance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "number_entrance", nullable = false)
    private int numberEntrance;
    @Column(name = "levels", nullable = false)
    private int numberOfLevels;
    @Column(name = "pipes", nullable = false)
    private int numberOfPipes;
    @Column(name = "fire_boxes", nullable = false)
    private int numberOfFireBoxes;
    @Column(name = "fire_cranes", nullable = false)
    private int numberOfFireCranes;
    @Column(name = "first_level", nullable = false)
    private boolean hasFirstLevel;
    @Column(name = "work", nullable = false)
    private boolean work;
    @Column(name = "basement", nullable = false)
    private boolean basement;
    @Column(name = "attic", nullable = false)
    private boolean attic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_details_id")
    private HouseDetails houseDetails;
    @OneToOne(mappedBy = "entrance", cascade = CascadeType.ALL)
    private FireBox fireBox;


}



