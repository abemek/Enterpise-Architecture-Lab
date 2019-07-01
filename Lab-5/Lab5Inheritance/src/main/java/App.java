import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab5");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product cd = new CD("CD1","Christian Song","Toby Mac");
        Product dvd = new DVD("DVD1","Movie","Comedy");
        Product book = new Book("BOOK1","Novel","This Momentary Marriage");
        OrderLine orderLine1 = new OrderLine(5,book);
        OrderLine orderLine2 = new OrderLine(4,cd);
        OrderLine orderLine3 = new OrderLine(2,dvd);
        Order order = new Order(new Date());
        order.addOrderLine(orderLine1);
        order.addOrderLine(orderLine2);
        order.addOrderLine(orderLine3);
        Customer customer = new Customer("Abenezer", "Mekonnen");
        order.setCustomer(customer);
        em.persist(order);
        em.getTransaction().commit();



    }
}
