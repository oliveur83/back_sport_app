package com.appsport.singloton;

public class StatisticsManager {

    // Instance unique de la classe
    private static volatile StatisticsManager instance;

    // Données des statistiques
    private int totalDistance;
    private int totalTime;

    // Constructeur privé pour empêcher l'instanciation extérieure
    public StatisticsManager() {
        this.totalDistance = 0;
        this.totalTime = 0;
    }

    // Méthode pour obtenir l'instance unique de la classe
    public static StatisticsManager getInstance() {
        if (instance == null) {
            synchronized (StatisticsManager.class) {
                if (instance == null) {
                    instance = new StatisticsManager();
                }
            }
        }
        return instance;
    }

    // Méthode pour ajouter une séance d'entraînement
    public void addRun(int distance, int time) {
        this.totalDistance += distance;
        this.totalTime += time;
    }

    // Méthode pour obtenir la distance totale
    public int getTotalDistance() {
        return totalDistance;
    }

    // Méthode pour obtenir le temps total
    public int getTotalTime() {
        return totalTime;
    }
}