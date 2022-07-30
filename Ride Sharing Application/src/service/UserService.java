package service;

import model.Ride;
import model.User;
import model.Vehicle;

import java.util.ArrayList;


public class UserService {
   public ArrayList<User> users=new ArrayList<>();

    public void addUser(String name,String gender, int age){
        User user=new User();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setVehicles(new ArrayList<Vehicle>());
        users.add(user);

    }
    public void addVehicle(String name,String vehicleType, String RegNo){
       Vehicle vehicle=new Vehicle();
       vehicle.setType(vehicleType);
       vehicle.setVehicleNo(RegNo);
       vehicle.setRidesTaken(new ArrayList<Ride>());
       vehicle.setEndRide(false);
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName()!=null && users.get(i).getName().equalsIgnoreCase(name)){
                users.get(i).getVehicles().add(vehicle);
            }
        }
    }
}
