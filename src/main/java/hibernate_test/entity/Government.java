package hibernate_test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY,mappedBy = "government")
    private List<PlanethStore> planethStores;
    public Government(String value) {
        this.value = value;
    }

    public Government() {
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

    public void addPlanethStoretoGovernment(PlanethStore planethStore) {
        if (this.planethStores == null) {
            this.planethStores = new ArrayList<>();
        }
        this.planethStores.add(planethStore);
        planethStore.setGovernment(this);
    }

    public List<PlanethStore> getPlanethStores() {
        for (PlanethStore planethStore : this.planethStores) {
            System.out.println( "planethStore" + planethStore);
        }
        return planethStores;
    }

    @Override
    public String toString() {
        return "Government{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
