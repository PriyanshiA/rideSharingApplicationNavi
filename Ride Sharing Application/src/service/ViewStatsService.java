package service;

import model.User;

import java.util.ArrayList;

public class ViewStatsService{
    public void printRideStats(ArrayList<User> users){
        for(User user: users){
            System.out.println(user.getName()+" : "+ user.getRidesTaken()+"Taken , "+user.getRidesOffered()+"  Offered");
        }

    }
}
