package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "School")
    @MapKey(name = "id")
    private Map<Long, Student> students = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
       students.put(student.getId(),student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
}
