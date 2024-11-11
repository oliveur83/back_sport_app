package com.appsport.osberver;

import com.appsport.model.Data;

import java.util.ArrayList;
import java.util.List;

public class TrailData implements Subject {
    private List<Observer> observers;
    private Data data;

    public TrailData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    public void setData(Data data) {
        this.data = data;
        notifyObservers();
    }
}