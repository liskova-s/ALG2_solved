/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25_liskova_autobus;

/**
 *
 * @author sarka
 */
public class Bus {

    private int seats = 40;
    private int code = 0;
    private String company = "none";
    private int passengers = 0;

    Bus(int seats, int code, String company) {
        this.seats = seats;
        this.code = code;
        this.company = company;
    }

    Bus() {
    }

    public int getNumSeats() {
        return seats;
    }

    public int getCode() {
        return code;
    }

    public int getNumPassengers() {
        return passengers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("Bus number %d operated by %s with number of seats: %d has %d passengers on board. ", code, company, seats, passengers);
    }

    public void setPassengersIn(int in) {
        passengers += in;
    }

    public void setPassengersOut(int out) {
        if (out == -1) {
            everybodyOff();
        } else {
            passengers -= out;
        }
    }

    public void everybodyOff() {
        passengers = 0;
    }

    public int checkOut(int num) {
        if (num > passengers) {
            System.out.println("Nobody on board - number of passengers getting off the bus: " + passengers);
            return -1;
        } else {
            return num;
        }
    }

    public int checkIn(int num) {
        if (num > (seats - passengers)) {
            num = seats - passengers;
            System.out.println("Only " + num + " passengers could get on the bus.");
        }
        return num;
    }
}
