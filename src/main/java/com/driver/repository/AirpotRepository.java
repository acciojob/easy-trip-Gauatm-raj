package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class AirpotRepository {

    @Autowired
     FlightRepository flightRepository;

    HashMap<String, Airport> airpotRepository;

    public AirpotRepository(HashMap<Integer, Airport> airpotRepository) {
        this.airpotRepository = new HashMap<>();
    }

    //add flight to db
    public void addAirport(Airport airport){
        airpotRepository.put(airport.getAirportName(),airport);

    }
    //find by name
    public Airport byname(String name){
        return airpotRepository.get(name);
    }

    //find by city
    public Airport byCity(City name){
        return airpotRepository.get(name);
    }

    //find largest  terminal Airport
    public String LargestAirport(){
        int maxTerminals = -1;
        String largestAirportName = "";

        for (String name : airpotRepository.keySet()) {
            Airport currAirport = airpotRepository.get(name);
            int terminals = currAirport.getNoOfTerminals();

            if (terminals > maxTerminals) {
                maxTerminals = terminals;
                largestAirportName = currAirport.getAirportName();
            } else if (terminals == maxTerminals && largestAirportName.compareTo(currAirport.getAirportName()) > 0) {
                largestAirportName = currAirport.getAirportName();
            }
        }

        return largestAirportName;
    }

    public int totalPassengerAirport(Date date, String airportName){
        int total=0;
        Airport airport=airpotRepository.get(airportName);
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
