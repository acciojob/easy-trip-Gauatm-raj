package com.driver.repo;

import com.driver.model.City;
import com.driver.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FlightRepository {

    HashMap<Integer, Flight> flightRepository;



    public FlightRepository() {
        this.flightRepository = new HashMap<>();
    }

      //add flight
    public void addFlight(Flight flight){
        Integer id=flight.getFlightId();
        flightRepository.put(id,flight);

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



}
