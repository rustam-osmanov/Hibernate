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
    @Column(name = "government_id")
    private int government_id;
    @Column(name = "wiki", columnDefinition = "hstore")
    @ColumnTransformer(write = "hstore(?)", read = "wiki::varchar")
    private String wiki;

    public PlanethStore(String name, double distance, int government_id, String wiki) {
        this.name = name;
        this.distance = distance;
        this.government_id = government_id;
        this.wiki = wiki;
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

    public int getGovernment_id() {
        return government_id;
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

    public void setGovernment_id(int government_id) {
        this.government_id = government_id;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @Override
    public String toString() {
        return "PlanethStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", government_id=" + government_id +
                ", wiki='" + wiki + '\'' +
                '}';
    }
}
