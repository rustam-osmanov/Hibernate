package hibernate_test.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "planethstore", schema = "test")
public class PlanethStore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planethstore_id_gen")
    @SequenceGenerator(name = "planethstore_id_gen", sequenceName = "test.planethstore_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "distance")
    private double distance;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "government_id")
    private Government government;
    @Column(name = "wiki", columnDefinition = "hstore")
    @ColumnTransformer(write = "hstore(?)", read = "wiki::varchar")
    private String wiki;

    public PlanethStore(String name, double distance, Government government, String wiki) {
        this.name = name;
        this.distance = distance;
        this.government = government;
        this.wiki = wiki;
    }

    public PlanethStore() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public String getWiki() {
        return wiki;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public Government getGovernment() {
        return government;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    @Override
    public String toString() {
        return "PlanethStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", wiki='" + wiki + '\'' +
                '}';
    }
}
