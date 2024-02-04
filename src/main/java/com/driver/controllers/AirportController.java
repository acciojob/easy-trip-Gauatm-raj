package com.driver.controllers;


import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import com.driver.service.AirpotService;
import com.driver.service.FlightService;
import com.driver.service.PassengerService;
import com.driver.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class AirportController {

    @Autowired
    AirpotService airpotService;

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    TicketService ticketService;


    @PostMapping("/add_airport") //done
    public String addAirport(@RequestBody Airport airport){
        airpotService.addAirport(airport);
        return "SUCCESS";
    }

    @GetMapping("/get-largest-aiport") //done
    public String getLargestAirportName(){
        return airpotService.LargestAirport();
    }

    @GetMapping("/get-shortest-time-travel-between-cities")//done
    public double getShortestDurationOfPossibleBetweenTwoCities(@RequestParam("fromCity") City fromCity, @RequestParam("toCity")City toCity){
        return flightService.getShortTimeBw2City(fromCity,toCity);
    }

    @GetMapping("/get-number-of-people-on-airport-on/{date}") //done
    public int getNumberOfPeopleOn(@PathVariable("date") Date date,@RequestParam("airportName")String airportName){
      return airpotService.totalPassengerAirport(date,airportName);
    }

    @GetMapping("/calculate-fare")//done
    public int calculateFlightFare(@RequestParam("flightId")Integer flightId){
        return flightService.calfare(flightId);

    }


    @PostMapping("/book-a-ticket") //done
    public String bookATicket(@RequestParam("flightId")Integer flightId,@RequestParam("passengerId")Integer passengerId) throws Exception {

        try{
            return ticketService.bookTicket(flightId,passengerId);
        }catch (Exception e){
           throw new Exception(e.getMessage());
        }

    }

    @PutMapping("/cancel-a-ticket")//done
    public String cancelATicket(@RequestParam("flightId")Integer flightId,@RequestParam("passengerId")Integer passengerId) throws Exception {

        try{
            return ticketService.CancelTicket(flightId,passengerId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @GetMapping("/get-count-of-bookings-done-by-a-passenger/{passengerId}")//done
    public int countOfBookingsDoneByPassengerAllCombined(@PathVariable("passengerId")Integer passengerId){
          return passengerService.totalticketbooked(passengerId);

    }

    @PostMapping("/add-flight")//done
    public String addFlight(@RequestBody Flight flight){
        flightService.addFlight(flight);
       return "SUCCESS";
    }


    @GetMapping("/get-aiportName-from-flight-takeoff/{flightId}") //done
    public String getAirportNameFromFlightId(@PathVariable("flightId")Integer flightId){
        return flightService.airportByFlightId(flightId);
    }


    @GetMapping("/calculate-revenue-collected/{flightId}")
    public int calculateRevenueOfAFlight(@PathVariable("flightId")Integer flightId){

        //Calculate the total revenue that a flight could have
        //That is of all the passengers that have booked a flight till now and then calculate the revenue
        //Revenue will also decrease if some passenger cancels the flight


        return 0;
    }


    @PostMapping("/add-passenger") //done
    public String addPassenger(@RequestBody Passenger passenger){
       passengerService.addPassenger(passenger);
       return "SUCCESS";
    }


}
