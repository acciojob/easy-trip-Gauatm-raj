package com.driver.service;

import com.driver.model.Airport;
import com.driver.repository.AirpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AirpotService {

    @Autowired
    AirpotRepository airpotRepository;

    //add Airport
    public void addAirport(Airport airport){
         airpotRepository.addAirport(airport);
    }

   //Largest Airpot
    public String LargestAirport(){
        return airpotRepository.LargestAirport();
    }

    //total passenger on an airport at specific date
    public int totalPassengerAirport(Date date,String airportName){
        return airpotRepository.totalPassengerAirport(date,airportName);
    }
}
