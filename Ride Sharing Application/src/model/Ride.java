package model;

public class Ride {
    private String origin;
    private String destination;
    private int numberOfVacantSeats;



    public int getNumberOfVacantSeats() {
        return numberOfVacantSeats;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNumberOfVacantSeats(int numberOfVacantSeats) {
        this.numberOfVacantSeats = numberOfVacantSeats;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }



}
