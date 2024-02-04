package com.driver.repo;

import com.driver.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class TicketRepository {

   HashMap<UUID,Ticket> ticketRepository;



    public TicketRepository(HashMap<Integer, Ticket> ticketRepository) {
        this.ticketRepository = new HashMap<>();
    }

    //Book ticket
    public void addTicket(Ticket ticket) throws Exception{

        ticketRepository.put(ticket.getTicketId(),ticket);
    }


    public void deleteTicket(UUID id){
        ticketRepository.remove(id);
    }
}
