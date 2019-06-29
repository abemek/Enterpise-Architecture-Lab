package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    @Column(name = "`from`")
    private String from;
    @Column(name = "`to`")
    private String to;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight")
    private List<Passenger> passengers = new ArrayList<>();
    public Flight(String flightNumber, String from, String to) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
    }

    public boolean addPassenger(Passenger passenger){
        if(passengers.add(passenger)) return true;
        return false;
    }

    public boolean removePassenger(Passenger passenger){
        if(passengers.remove(passenger)) return true;
        return false;
    }
}
