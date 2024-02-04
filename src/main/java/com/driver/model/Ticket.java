package com.driver.model;

import java.util.UUID;


public class Ticket {


    private UUID ticketId;

    private Flight flight;

    private Passenger passenger;



    public Ticket(Flight flight, Passenger passenger) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passenger = passenger;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
