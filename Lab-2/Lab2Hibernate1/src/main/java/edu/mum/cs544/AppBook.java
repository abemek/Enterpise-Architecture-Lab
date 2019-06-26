package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AppBook {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws  Exception {


        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("Purpose Driven Life","1a2b3c","Rick Warren", 56.9, new GregorianCalendar(1956, Calendar.JANUARY,12).getTime());
        em.persist(book1);
        Book book2 = new Book("Rich dad poor dad","1a2b3c","Robert Kiyosaki", 156.9, new GregorianCalendar(1963, Calendar.OCTOBER,22).getTime());
        em.persist(book2);
        Book book3 = new Book("A Hunger of God","1a2b3c","John Piper", 256.9, new GregorianCalendar(1976, Calendar.DECEMBER,16).getTime());
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("from Book ", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Author= " + book.getAuthor() + ", Price= "+ book.getPrice() + ", Publish-Date= "
                    + book.getPublish_date().toString());
        }

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        bookList.get(1).setTitle("Don't wast your life");
        bookList.get(1).setPrice(37);
        em.persist(bookList.get(1));
        em.remove(bookList.get(2));
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Book book : bookList) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Author= " + book.getAuthor() + ", Price= "+ book.getPrice() + ", Publish-Date= "
                    + book.getPublish_date());
        }

        em.getTransaction().commit();
        em.close();

    }
}
