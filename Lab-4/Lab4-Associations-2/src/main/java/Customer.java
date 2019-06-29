import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Reservation>  reservations = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public  void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
}
