package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    //add flight
    public void addFlight(Flight flight){
        flightRepository.addFlight(flight);
    }

    // get airpot name by city
    public String airportByFlightId(Integer fId){
        return flightRepository.airportByFlightId(fId);
    }

    //calculate fare
    public int calfare(Integer fid){
        return flightRepository.calfare(fid);
    }

   //shortest time between two city
    public double getShortTimeBw2City(City  one , City two){
        return flightRepository.getShortTimeBw2City(one,two);
    }
}
