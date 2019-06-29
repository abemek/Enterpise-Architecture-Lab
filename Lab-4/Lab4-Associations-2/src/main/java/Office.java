import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Office  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "office",cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Office(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        employee.setOffice(this);
        employees.add(employee);
    }
}
