package hibernate_test.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "planet", schema = "test")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planet_id_gen")
    @SequenceGenerator(name = "planet_id_gen", sequenceName = "test.planet_id_seq", allocationSize = 1)
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
    @Column(name = "wiki_jsonb", columnDefinition = "jsonb")
    @ColumnTransformer(write = "?::jsonb", read = "wiki_jsonb::varchar")
    private String wiki_jsonb;

    public Planet() {
    }

    public Planet(String name, double distance, int government_id, String wiki, String wiki_jsonb) {
        this.name = name;
        this.distance = distance;
        this.government_id = government_id;
        this.wiki = wiki;
        this.wiki_jsonb = wiki_jsonb;
    }

    public int getId() {
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


    public String getWiki_jsonb() {
        return wiki_jsonb;
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

    public String getWiki() {
        return wiki;
    }

    public void setWiki_jsonb(String wiki_jsonb) {
        this.wiki_jsonb = wiki_jsonb;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", government_id=" + government_id +
                ", wiki='" + wiki + '\'' +
                ", wiki_jsonb='" + wiki_jsonb + '\'' +
                '}';
    }
}