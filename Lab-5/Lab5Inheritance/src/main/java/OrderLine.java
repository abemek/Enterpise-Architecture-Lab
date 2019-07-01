import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
