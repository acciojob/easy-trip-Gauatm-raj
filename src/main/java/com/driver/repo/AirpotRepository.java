package com.driver.repo;

import com.driver.model.Airport;
import com.driver.model.City;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AirpotRepository {



    HashMap<String, Airport> airpotRepository;

    public AirpotRepository() {
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
        Airport ans=null;
        for(String airport : airpotRepository.keySet()){
            Airport airport1=airpotRepository.get(airport);
            if(airport1.getCity().equals(name)){
              ans=airport1;
            }
        }
        return ans;
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


}
