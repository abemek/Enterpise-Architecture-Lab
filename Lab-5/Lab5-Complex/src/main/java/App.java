import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab5complex");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Doctor doctor = new Doctor("Eye Doctor", "Ayehubrhan","Yifru");
        Patient patient = new Patient("Zeleke","1000 N 4th Street","52557","Fairfield");
        Payment payment = new Payment("10-25-2019", 250);
        Appointment appointment = new Appointment("10-25-2019",patient,payment,doctor);
        em.persist(appointment);
        em.getTransaction().commit();

        System.out.println("         ******Printing the Database******");
        Appointment appointment1=em.find(Appointment.class,appointment.getId());
        System.out.println("Patient Name: "+appointment1.getPatient().getName()+", Street: "+appointment1.getPatient().getStreet() +
                ", City: "+appointment1.getPatient().getCity()+", ZIP: "+appointment1.getPatient().getZip());
        System.out.println("Appointement Date: "+appointment1.getAppdate()+", Pay Date: "+appointment1.getPayment().getPaydate()
                +", Amount: "+appointment1.getPayment().getAmount());
        System.out.println("Doctor Name: "+appointment1.getDoctor().getFirstname()+" "+appointment1.getDoctor().getLastname()+", Type: "+appointment1.getDoctor().getDoctortype());

    }
}
