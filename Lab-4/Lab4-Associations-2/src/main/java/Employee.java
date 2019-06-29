import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Department department;
    @ManyToOne(cascade = CascadeType.ALL)
    private Office office;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
