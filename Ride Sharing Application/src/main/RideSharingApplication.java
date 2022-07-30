package main;

import service.RideService;
import service.UserService;
import service.ViewStatsService;

public class RideSharingApplication {
    public static void main(String[] args){
        UserService userService=new UserService();
        //add users and vehicles
        userService.addUser("Rohan","M",36);
        userService.addVehicle("Rohan","Swift","KA-01-12345");
        userService.addUser("Shashank","M",29);
        userService.addVehicle("Shashank","Baleno","TS-05-62395");
        userService.addUser("Nandini","F",29);
        userService.addUser("Shipra","F",27);
        userService.addVehicle("Shipra","Polo","KA-05-41491");
        userService.addVehicle("Shipra","Activa","KA-12-12332");
        userService.addUser("Gaurav","M",29);
        userService.addUser("Rahul","M",35);
        userService.addVehicle("Rahul","XUV","KA-05-1234");

        //offer 4 rides by 3 users
        RideService rideService=new RideService();
        rideService.offerRide(userService.users,"Rohan","Hyderabad",1,"Swift","KA-01-12345","Bangalore");
        rideService.offerRide(userService.users,"Shipra","Bangalore",1,"Activa","KA-12-12332","Mysore");
        rideService.offerRide(userService.users,"Shipra","Bangalore",2,"Polo","KA-05-41491","Mysore");
        rideService.offerRide(userService.users,"Shashank","Hyderabad",2,"Baleno","TS-05-62395","Bangalore");
        rideService.offerRide(userService.users,"Rahul","Hyderabad",5,"XUV","KA-05-1234","Bangalore");
        rideService.offerRide(userService.users,"Rohan","Bangalore",1,"Swift","KA-01-12345","Pune");

        //select rides for users
        rideService.selectRide(userService.users,"Nandini","Bangalore","Mysore",1,"Most Vacant");
        rideService.selectRide(userService.users,"Gaurav","Bangalore","Mysore",1,"Preferred Vehicle=Activa");
        rideService.selectRide(userService.users,"Shashank","Mumbai","Bangalore",1,"Most Vacant");
        rideService.selectRide(userService.users,"Rohan","hyderabad","Bangalore",1,"Preferred Vehicle=Baleno");
        rideService.selectRide(userService.users,"Shashank","Hyderabad","Bangalore",1,"Preferred Vehicle=Polo”");

        //endRides

        rideService.endRide(userService.users,"Rohan","KA-01-12345");
        rideService.endRide(userService.users,"Shipra","KA-12-12332");
        rideService.endRide(userService.users,"Shipra","KA-05-41491");
        rideService.endRide(userService.users,"Shashank","TS-05-62395");

        //print ride stats
        ViewStatsService viewStatsService=new ViewStatsService();
        viewStatsService.printRideStats(userService.users);
    }


}
