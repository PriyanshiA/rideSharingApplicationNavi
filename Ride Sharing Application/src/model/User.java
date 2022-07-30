package model;

import java.util.List;

public class User {
    private String name;
    private String gender;
    private int age;
    private List<Vehicle> vehicles;
    private int ridesTaken;
    private int ridesOffered;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRidesOffered() {
        return ridesOffered;
    }

    public int getRidesTaken() {
        return ridesTaken;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setRidesOffered(int ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public void setRidesTaken(int ridesTaken) {
        this.ridesTaken = ridesTaken;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
