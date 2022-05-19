package exam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "fire_box")
public class FireBox {

    @Id
    private long id;
    @Column(name = "complete")
    private boolean complete;
    @Column(name = "double_roll")
    private boolean hasDoubleRoll;
    @Column(name = "fire_hose")
    private boolean hasFireHose;
    @Column(name = "access")
    private boolean access;
    @Column(name = "component")
    private boolean hasComponent;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Entrance entrance;

}
