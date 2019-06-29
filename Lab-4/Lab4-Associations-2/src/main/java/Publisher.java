import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    @Temporal(TemporalType.DATE)
    private Date  publishDate;

    public Publisher(String name, String author, Date publishDate) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
    }


}
