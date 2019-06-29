import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ISBN;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher",joinColumns = {@JoinColumn(name = "book_id")}
    ,inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Publisher publisher;

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }


}
