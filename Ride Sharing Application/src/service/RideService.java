package service;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import constants.Constants;
import model.Ride;
import model.User;
import model.Vehicle;

import java.util.ArrayList;

public class RideService {
    UtilityService utilityService=new UtilityService();
    public void offerRide(ArrayList<User> users,String name, String origin, int availableSeats, String vehicleType, String regNo, String destination){


        //add ride offered by the user
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName()!=null && users.get(i).getVehicles()!=null){
                for(int j=0;j<users.get(i).getVehicles().size();j++){
                    //check if ride already exists
                    if(users.get(i).getVehicles().get(j).getVehicleNo().equalsIgnoreCase(regNo) && users.get(i).getVehicles().get(j).getRideOffered()!=null){
                        System.out.println("OOPS! Ride already offered by the user"+name);
                        return ;
                    }
                    if(users.get(i).getVehicles().get(j).getVehicleNo().equalsIgnoreCase(regNo)){
                        Ride offeredRide=utilityService.createOfferedRide(origin,destination,availableSeats);
                        users.get(i).getVehicles().get(j).setRideOffered(offeredRide);
                        users.get(i).setRidesOffered(users.get(i).getRidesOffered()+1);
                        break;
                    }
                }
            }
}
    }
    public void selectRide(ArrayList<User> users,String name, String origin, String destination, int seats, String preference){
        //select on basis of most vacancy
        if(preference!=null && preference.equalsIgnoreCase(Constants.mostVacant)){
            utilityService.selectByMostVacancy(users,name,origin,destination,seats);
        }
        //select on basis of vehicle type
        else if(preference!=null){
            String parts[] = preference.split("=");
            utilityService.selectByVehicleType(users,name,origin,destination,seats,parts[1]);
        }

    }
    public void endRide(ArrayList<User> users,String name,String vehicleNo){
        for(User user:users){
            for(Vehicle vehicle:user.getVehicles()){
                if(vehicle.getVehicleNo().equalsIgnoreCase(vehicleNo))
                    vehicle.setEndRide(true);
            }
        }
    }

}
