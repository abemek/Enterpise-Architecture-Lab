import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {
    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
