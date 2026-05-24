package hibernate_test.entity;

import javax.persistence.*;

@Entity
@Table(name = "government", schema = "test")
public class Government {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "government_id_gen")
    @SequenceGenerator(name = "government_id_gen", sequenceName = "test.government_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "value")
    private String value;

    public Government(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public Integer getId() {
        return id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Government{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
