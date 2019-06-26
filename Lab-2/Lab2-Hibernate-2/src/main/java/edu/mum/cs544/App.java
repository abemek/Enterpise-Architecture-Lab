package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws  Exception {


        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students ", Students.class);
        List<Students> studentsList = query.getResultList();
        for (Students student : studentsList) {
            System.out.println("Name= " + student.getName() + ", Email= "
                    + student.getEmail() + ", Password= " + student.getPassword());
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Students std = new Students();
        std.setId(63);
        std.setName("Abenezer");
        std.setEmail("abenmum@gmail.com");
        std.setPassword("mypassword");
        em.persist(std);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query2 = em.createQuery("from edu.mum.cs544.Students ", Students.class);
        List<Students> studentsList2 = query2.getResultList();
        for (Students student : studentsList2) {
            System.out.println("Name= " + student.getName() + ", Email= "
                    + student.getEmail() + ", Password= " + student.getPassword());
        }

        em.getTransaction().commit();
        em.close();


    }
}
