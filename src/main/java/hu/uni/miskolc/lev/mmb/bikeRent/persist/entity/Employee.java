package hu.uni.miskolc.lev.mmb.bikeRent.persist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @Min(130000)
    private int salary;

    @OneToMany(
            mappedBy ="starterEmployee",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    //@JsonBackReference(value = "starter")
    @JsonIgnore
    private List<Rent> startedRents;

    @OneToMany(
            mappedBy ="closerEmployee",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    //@JsonBackReference(value = "closer")
    @JsonIgnore
    private List<Rent> closedRents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee that = (Employee) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
