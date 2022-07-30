package model;

import java.util.List;

public class Vehicle {
    private String type;
    private String vehicleNo;
    private Ride rideOffered;
    private List<Ride> ridesTaken;
    private boolean endRide;


    public String getType() {
        return type;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Ride getRideOffered() {
        return rideOffered;
    }

    public void setRidesTaken(List<Ride> ridesTaken) {
        this.ridesTaken = ridesTaken;
    }

    public void setRideOffered(Ride rideOffered) {
        this.rideOffered = rideOffered;
    }

    public List<Ride> getRidesTaken() {
        return ridesTaken;
    }

    public boolean isEndRide() {
        return endRide;
    }

    public void setEndRide(boolean endRide) {
        this.endRide = endRide;
    }
}
