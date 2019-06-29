import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reservationNo;
    private String reservationDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Reservation(String reservationNo, String reservationDetail) {
        this.reservationNo = reservationNo;
        this.reservationDetail = reservationDetail;
    }
}
