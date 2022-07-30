package service;

import model.Ride;
import model.User;
import java.util.ArrayList;

public class UtilityService {

  public Ride createOfferedRide(String origin, String destination, int availableSeats) {
    Ride ride = new Ride();
    ride.setOrigin(origin);
    ride.setDestination(destination);
    ride.setNumberOfVacantSeats(availableSeats);
    return ride;
  }

  public void selectByVehicleType(ArrayList<User> users, String name, String origin, String destination, int seats, String vehicleType) {
    int flag = 0;
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getVehicles().size() != 0) {
        for (int j = 0; j < users.get(i).getVehicles().size(); j++) {
          if (users.get(i).getVehicles().get(j).getType().equalsIgnoreCase(vehicleType)
              && users.get(i).getVehicles().get(j).getRideOffered().getNumberOfVacantSeats() != 0
              && users.get(i).getVehicles().get(j).getRideOffered().getOrigin().equalsIgnoreCase(origin)
              && users.get(i).getVehicles().get(j).getRideOffered().getDestination().equalsIgnoreCase(destination)) {
            users.get(i).getVehicles().get(j).getRideOffered().setNumberOfVacantSeats(users.get(i).getVehicles().get(j).getRideOffered().getNumberOfVacantSeats() - seats);
            flag = 1;
              increaseRidesTakenCount(users,name);
            break;
          }
        }

      }
    }
    if (flag == 0) System.out.println("OOPS! No Ride found for user" + name);
  }

  public void selectByMostVacancy(ArrayList<User> users, String name, String origin, String destination, int seats) {
    int currRideSeats = 0, flag = 0;
    Ride finalRide = new Ride();
    for (int i = 0; i < users.size(); i++) {
      for (int j = 0; j < users.get(i).getVehicles().size(); j++) {
        if (users.get(i).getVehicles().get(j).getRideOffered().getNumberOfVacantSeats() != 0
            && users
                .get(i)
                .getVehicles()
                .get(j)
                .getRideOffered()
                .getOrigin()
                .equalsIgnoreCase(origin)
            && users
                .get(i)
                .getVehicles()
                .get(j)
                .getRideOffered()
                .getDestination()
                .equalsIgnoreCase(destination)) {
          Ride ride = users.get(i).getVehicles().get(j).getRideOffered();
          if (ride.getNumberOfVacantSeats() > currRideSeats) {
            currRideSeats = ride.getNumberOfVacantSeats();
            finalRide = ride;
            flag = 1;
          }
        }
      }
    }
    if (flag == 0) {
      System.out.println("OOPS! No Ride found for user : " + name);
      return;
    } else {
      for (int i = 0; i < users.size(); i++) {
        for (int j = 0; j < users.get(i).getVehicles().size(); j++) {
          if (users.get(i).getVehicles().get(j).getRideOffered().equals(finalRide)) {
            users
                .get(i)
                .getVehicles()
                .get(j)
                .getRideOffered()
                .setNumberOfVacantSeats(
                    users.get(i).getVehicles().get(j).getRideOffered().getNumberOfVacantSeats()
                        - seats);
            break;
          }
        }
      }
        increaseRidesTakenCount(users,name);
    }

  }

  public void increaseRidesTakenCount(ArrayList<User> users, String name) {
    for (User user : users) {
      if (user.getName().equals(name)) {
        user.setRidesTaken(user.getRidesTaken() + 1);
        break;
      }
    }
  }
}