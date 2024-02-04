package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FlightRepository {

    HashMap<Integer, Flight> flightRepository;

    @Autowired
    AirpotRepository airpotRepository;

    public FlightRepository(HashMap<Integer, Flight> flightRepository) {
        this.flightRepository = new HashMap<>();
    }

      //add flight
    public void addFlight(Flight flight){
        Integer id=flight.getFlightId();
        flightRepository.put(id,flight);
        Airport airport1= airpotRepository.byCity(flight.getFromCity());
        Airport airport2= airpotRepository.byCity(flight.getToCity());
        airport1.getFlightId().add(id);
        airport2.getFlightId().add(id);
    }

    //find shortest time between two given cities
    public double getShortTimeBw2City(City one, City two){
        double shortestDuration = -1;

        for (Integer id : flightRepository.keySet() ) {

            Flight f=flightRepository.get(id);
            // Check if the flight connects the specified fromCity and toCity directly
            if (f.getFromCity().equals(one) && f.getToCity().equals(two)) {
                if (shortestDuration == -1 || f.getDuration() < shortestDuration) {
                    shortestDuration = f.getDuration();
                }
            }
        }

        return shortestDuration;
    }

    //get by id
    public Flight getById(Integer fId){
        return flightRepository.get(fId);
    }


    // get airpot name by city
    public String airportByFlightId(Integer fId){
        Flight f=flightRepository.get(fId);
        Airport airport=airpotRepository.byCity(f.getFromCity());
        if(airport==null){
            return null;
        }
        return airport.getAirportName();
    }


    //calculate  fare
    public int calfare(Integer fId){
       Flight f=flightRepository.get(fId);
       int fare= 3000 + f.getNumberOfPassengers() * 50;
       return fare;
    }
}
