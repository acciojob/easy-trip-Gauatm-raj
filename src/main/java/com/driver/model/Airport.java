package com.driver.model;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {

    @Id
    @Column(unique = true)
    private String airportName; //This is the unique key

    private int noOfTerminals;

    private City city;  //GIVEN : There will be only 1 airport in 1 city

    private List<Integer> flightId = new ArrayList<>();

    public Airport() {
    }

    public Airport(String airportName, int noOfTerminals, City city) {
        this.airportName = airportName;
        this.noOfTerminals = noOfTerminals;
        this.city = city;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getNoOfTerminals() {
        return noOfTerminals;
    }

    public void setNoOfTerminals(int noOfTerminals) {
        this.noOfTerminals = noOfTerminals;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Integer> getFlightId() {
        return flightId;
    }

    public void setFlightId(List<Integer> flightId) {
        this.flightId = flightId;
    }
}
