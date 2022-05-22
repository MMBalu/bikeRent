package hu.uni.miskolc.lev.mmb.bikeRent.persist.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rent")
@ToString
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rent_bike",
            joinColumns = @JoinColumn(name = "rent_id"),
            inverseJoinColumns = @JoinColumn(name = "bike_id")
    )
    @NotNull
    //@JsonManagedReference
    private Set<Bike> bikes;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonManagedReference
    private Customer customer;


    private LocalDateTime startTime = LocalDateTime.now();

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonManagedReference(value = "starter")
    private Employee starterEmployee;


    private LocalDateTime closeTime;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonManagedReference(value = "closer")
    private Employee closerEmployee;

    @PreRemove
    private void beforeRemove(){
        for(Bike bike : bikes){
            bike.getRents().remove(this);
        }
        customer.getRents().remove(this);
        starterEmployee.getStartedRents().remove(this);
        closerEmployee.getClosedRents().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rent that = (Rent) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
