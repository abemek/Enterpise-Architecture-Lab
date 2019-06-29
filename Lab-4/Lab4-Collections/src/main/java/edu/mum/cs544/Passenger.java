package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    private String ticketNumber;


    public Passenger(String firstName, String lastName, String ticketNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketNumber = ticketNumber;
    }



}
