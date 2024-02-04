package com.driver.repository;

import com.driver.model.Flight;
import com.driver.model.Passenger;
import com.driver.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TicketRepository {

   HashMap<Integer,Ticket> ticketRepository;

    @Autowired
    AirpotRepository airpotRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public TicketRepository(HashMap<Integer, Ticket> ticketRepository) {
        this.ticketRepository = new HashMap<>();
    }

    //Book ticket
    public String bookTicket(Integer flightId, Integer passengerId) throws Exception{
        Flight f=flightRepository.getById(flightId);
        Passenger p=passengerRepository.getById(passengerId);

        if((f==null || p==null) || (f.getNumberOfPassengers()>f.getMaxCapacity() && p.isBookedTicket())){
            throw new Exception("FAILURE");
        }

        Ticket ticket=new Ticket(f,p);
        f.setNumberOfPassengers(f.getNumberOfPassengers()+1);
        p.setCountOfBookingsDoneByPassengerAllCombined(p.getCountOfBookingsDoneByPassengerAllCombined()+1);
        ticketRepository.put(ticket.getTicketId(),ticket);
        p.setTicketId(ticket.getTicketId());

         return "SUCCESS";
    }

    public String cancelTicket(Integer flightId, Integer passengerId) throws Exception{
        Flight f=flightRepository.getById(flightId);
        Passenger p=passengerRepository.getById(passengerId);

        if(f==null || p==null || p.isBookedTicket()){
            throw new Exception("FAILURE");
        }

        f.setNumberOfPassengers(f.getNumberOfPassengers()-1);
        p.setCountOfBookingsDoneByPassengerAllCombined(p.getCountOfBookingsDoneByPassengerAllCombined()-1);
        p.setBookedTicket(false);
        int id=p.getTicketId();
        ticketRepository.remove(id);


        return "SUCCESS";
    }
}
