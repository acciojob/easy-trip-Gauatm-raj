package com.driver.service;

import com.driver.model.Passenger;
import com.driver.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    //add Passenger
    public void addPassenger(Passenger p){
        passengerRepository.addPassenger(p);
    }

    public Integer totalticketbooked(Integer pid){
        return passengerRepository.totalticketbooked(pid);
    }

}
