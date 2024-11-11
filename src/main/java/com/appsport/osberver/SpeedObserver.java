package com.appsport.osberver;

import com.appsport.model.Data;

public class SpeedObserver implements Observer {
    @Override
    public void update(Data data) {
        double speed = data.getDistance() / data.getTime();
        System.out.println("Average Speed: " + speed + " km/h");
    }
}
