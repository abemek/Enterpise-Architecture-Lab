import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.addStudent(this);
    }
}
