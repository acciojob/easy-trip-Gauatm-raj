package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.repo.AirpotRepository;
import com.driver.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AirpotRepository airpotRepository;

    //add flight
    public void addFlight(Flight flight){
        flightRepository.addFlight(flight);
        Integer id=flight.getFlightId();
        Airport airport1= airpotRepository.byCity(flight.getFromCity());
        Airport airport2= airpotRepository.byCity(flight.getToCity());
        airport1.getFlightId().add(id);
        airport2.getFlightId().add(id);
    }

    // get airpot name by city
    public String airportByFlightId(Integer fId){
        Flight f=flightRepository.getById(fId);
        Airport airport=airpotRepository.byCity(f.getFromCity());
        return airport.getAirportName();
    }

   // calculate fare
   public int calfare(Integer fid){
       Flight f=flightRepository.getById(fid);
       int fare= 3000 + f.getNumberOfPassengers() * 50;
       return fare;
    }

   //shortest time between two city
    public double getShortTimeBw2City(City  one , City two){
        return flightRepository.getShortTimeBw2City(one,two);
    }
}
