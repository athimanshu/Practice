package algoexpert.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
     int numberOfCities = distances.length;
     int milesRemaining = 0;

     int indexOfStartingCandidate = 0;
     int milesRemainingAtStartingCityIndex = 0;

     for(int i =1;i<numberOfCities;i++){
        int distanceFromLastCity = distances[i-1];
        int fuelFromLastCity = fuel[i-1];
        milesRemaining += fuelFromLastCity*mpg - distanceFromLastCity;
        if(milesRemaining<milesRemainingAtStartingCityIndex){
            milesRemainingAtStartingCityIndex = milesRemaining;
            indexOfStartingCandidate = i;
        }
     }
     return indexOfStartingCandidate;
    }

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        ValidStartingCity obj = new ValidStartingCity();
        obj.validStartingCity(distances,fuel,mpg);
    }
}
