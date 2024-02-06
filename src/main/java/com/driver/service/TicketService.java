package com.driver.service;

import com.driver.model.Flight;
import com.driver.model.Passenger;
import com.driver.model.Ticket;
import com.driver.repo.AirpotRepository;
import com.driver.repo.FlightRepository;
import com.driver.repo.PassengerRepository;
import com.driver.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketService {
   @Autowired
   TicketRepository ticketRepository;



    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

   public String bookTicket(Integer fid,Integer pid) throws Exception{
       Flight f=flightRepository.getById(fid);
       Passenger p=passengerRepository.getById(pid);

       if((f==null || p==null) || (f.getNumberOfPassengers()>f.getMaxCapacity() && p.isBookedTicket())){
           throw new Exception("FAILURE");
       }

       Ticket ticket=new Ticket(f,p);
       ticket.setTicketId(UUID.randomUUID());
       f.setNumberOfPassengers(f.getNumberOfPassengers()+1);
       p.setCountOfBookingsDoneByPassengerAllCombined(p.getCountOfBookingsDoneByPassengerAllCombined()+1);
       p.setBookedTicket(true);
       ticketRepository.addTicket(ticket);
       p.setTicketId(ticket.getTicketId());

       return "SUCCESS";
   }

    public String CancelTicket(Integer flightId, Integer passengerId) throws Exception {
        Flight f=flightRepository.getById(flightId);
        Passenger p=passengerRepository.getById(passengerId);

        if(f==null || p==null || !p.isBookedTicket()){
            throw new Exception("FAILURE");
        }

        f.setNumberOfPassengers(f.getNumberOfPassengers()-1);
        p.setCountOfBookingsDoneByPassengerAllCombined(p.getCountOfBookingsDoneByPassengerAllCombined()-1);
        p.setBookedTicket(false);
        UUID id=p.getTicketId();
        ticketRepository.deleteTicket(id);
        return "SUCCESS";
    }
}
