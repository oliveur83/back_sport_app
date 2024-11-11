package com.appsport.osberver;

import com.appsport.model.Data;

public class RecordObserver implements Observer {
    private double bestTime = Double.MAX_VALUE;
    private double longestDistance = 0;

    @Override
    public void update(Data data) {
        if (data.getTime() < bestTime) {
            bestTime = data.getTime();
            System.out.println("New Best Time: " + bestTime + " hours");
        }
        if (data.getDistance() > longestDistance) {
            longestDistance = data.getDistance();
            System.out.println("New Longest Distance: " + longestDistance + " km");
        }
    }
}
