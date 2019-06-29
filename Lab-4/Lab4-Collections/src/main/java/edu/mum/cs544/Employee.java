package edu.mum.cs544;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Set<Laptop> laptops = new HashSet<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public boolean addLaptop(Laptop laptop){
        if(laptops.add(laptop)){
            laptop.setEmployee(this);
            return true;
        }
        return false;
    }

    public boolean removeLaptop(Laptop laptop){
        if(laptops.remove(laptop)){
            laptop.setEmployee(null);
            return true;
        }
        return false;
    }


}
