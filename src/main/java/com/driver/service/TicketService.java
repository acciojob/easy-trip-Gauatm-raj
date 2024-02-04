package com.driver.service;

import com.driver.repository.AirpotRepository;
import com.driver.repository.FlightRepository;
import com.driver.repository.PassengerRepository;
import com.driver.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
   @Autowired
    TicketRepository ticketRepository;

   public String bookTicket(Integer fid,Integer pid) throws Exception{
       return ticketRepository.bookTicket(fid,pid);
   }

    public String CancelTicket(Integer flightId, Integer passengerId) throws Exception {
       return ticketRepository.cancelTicket(flightId,passengerId);
    }
}
