import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4");

        EntityManager em = emf.createEntityManager();

          em.getTransaction().begin();
          Employee employee1 = new Employee("Abenezer", "Mekonnen");
          Employee employee2 = new Employee("Someone", "John");
          Department department = new Department("CS","CSHead");
          department.addEmployee(employee1);
          department.addEmployee(employee2);
          em.persist(department);
          em.getTransaction().commit();

          em.getTransaction().begin();
          Publisher publisher = new Publisher("Aster Nega", "Paulos Fikadu", new GregorianCalendar(1986,12,11).getTime());
          Book book = new Book("WAA","124fdghj");
          book.setPublisher(publisher);
          em.persist(book);
          em.getTransaction().commit();

          em.getTransaction().begin();
          Student student = new Student(1L,"StudentName" , "StudentsLastName");
          student.addCourse(new Course("WAA","cs544"));
          em.persist(student);
          em.getTransaction().commit();

          em.getTransaction().begin();
          Customer customer = new Customer("CustomnerName");
          customer.addReservation(new Reservation("Res-Id", "This is the detail about the reservation"));
          em.persist(customer);
          em.getTransaction().commit();

          em.getTransaction().begin();
          Reservation reservation = new Reservation("Res2", "ResDesc");
          reservation.setBook(new Book("whatever","bookcode"));
          em.persist(reservation);
          em.getTransaction().commit();

          em.getTransaction().begin();
          Employee employeeO = new Employee("William" , "Smith");
          Office office = new Office("CsOffice");
          office.addEmployee(employeeO);
          em.persist(office);
          em.getTransaction().commit();

    }
}
