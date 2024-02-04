package com.driver.repository;

import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PassengerRepository {

    HashMap<Integer, Passenger> passengerRepository;

    public PassengerRepository(HashMap<Integer, Passenger> passengerRepository) {
        this.passengerRepository = new HashMap<>();
    }

    //add passenger
    public void addPassenger(Passenger p){
        passengerRepository.put(p.getPassengerId(), p);

    }

    //get by id
    public Passenger getById(Integer pId){
        return passengerRepository.get(pId);
    }

    //get total ticket book by a passenger by id

    public Integer totalticketbooked(Integer pId){
        Passenger p=passengerRepository.get(pId);
        return p.getCountOfBookingsDoneByPassengerAllCombined();
    }
}
