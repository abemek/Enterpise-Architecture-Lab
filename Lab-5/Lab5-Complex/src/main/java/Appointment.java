import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "patient")
    private Patient patient;
    @Embedded
    private Payment payment;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }
}