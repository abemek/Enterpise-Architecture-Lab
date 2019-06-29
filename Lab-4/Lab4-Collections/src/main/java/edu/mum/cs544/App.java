package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee("Abenezer", "Mekonnen");
        Laptop laptop1 = new Laptop("Lenovo", "330","azsx234d");
        employee1.addLaptop(laptop1);
        em.persist(employee1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Passenger passenger1 = new Passenger("John", "Smith", "123654");
        Passenger passenger2 = new Passenger("Doe", "Bone", "9876543");

        Flight flight = new Flight("FL-12354", "Ethiopia" , "USA");
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        em.persist(flight);
        em.getTransaction().commit();

        em.getTransaction().begin();
        School school = new School("Stanford");
        Student student = new Student(1L,"Feven", "Yeabsra");
        school.addStudent(student);
        em.persist(school);
        em.getTransaction().commit();
    }
}
