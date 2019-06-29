package edu.mum.cs544;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String serialNumber;
    @ManyToOne
    private Employee employee;

    public Laptop(String brand, String model, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(id, laptop.id) &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(model, laptop.model) &&
                Objects.equals(serialNumber, laptop.serialNumber) &&
                Objects.equals(employee, laptop.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, serialNumber, employee);
    }
}
