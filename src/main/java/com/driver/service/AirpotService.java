package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.Flight;
import com.driver.repo.AirpotRepository;
import com.driver.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirpotService {

    @Autowired
    AirpotRepository airpotRepository;

    @Autowired
    FlightRepository flightRepository;

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

        int total=0;
        Airport airport=airpotRepository.byname(airportName);
        List<Integer> id=airport.getFlightId();
        for(int curr:id){
            Flight f=flightRepository.getById(curr);
            if(f.getFlightDate().equals(date)){
                total+=f.getNumberOfPassengers();
            }
        }

        return total;

    }
}
