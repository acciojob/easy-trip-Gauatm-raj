package com.driver.model;


import java.util.UUID;


public class Passenger {


    private int passengerId; //This is a unique key for Passenger model :

    private String email;

    private String name;

    private int age;

    private boolean bookedTicket;

    private UUID ticketId;

    private int countOfBookingsDoneByPassengerAllCombined;

    public Passenger() {

    }

    public Passenger(int passengerId, String email, String name, int age) {
        this.passengerId = passengerId;
        this.email = email;
        this.name = name;
        this.age = age;
        this.bookedTicket=false;
        this.countOfBookingsDoneByPassengerAllCombined=0;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBookedTicket() {
        return bookedTicket;
    }

    public void setBookedTicket(boolean bookedTicket) {
        this.bookedTicket = bookedTicket;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public int getCountOfBookingsDoneByPassengerAllCombined() {
        return countOfBookingsDoneByPassengerAllCombined;
    }

    public void setCountOfBookingsDoneByPassengerAllCombined(int countOfBookingsDoneByPassengerAllCombined) {
        this.countOfBookingsDoneByPassengerAllCombined = countOfBookingsDoneByPassengerAllCombined;
    }
}
