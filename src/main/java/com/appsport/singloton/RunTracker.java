package com.appsport.singloton;

public class RunTracker {

    private StatisticsManager statsManager;

    public RunTracker() {
        // Obtenir l'instance unique de StatisticsManager
        this.statsManager = StatisticsManager.getInstance();
    }

    // Méthode pour enregistrer une nouvelle séance d'entraînement
    public void recordRun(int distance, int time) {
        statsManager.addRun(distance, time);
        System.out.println("Séance enregistrée : " + distance + " km en " + time + " minutes.");
    }

    // Méthode pour afficher les statistiques
    public void displayStatistics() {
        int totalDistance = statsManager.getTotalDistance();
        int totalTime = statsManager.getTotalTime();
        System.out.println("Distance Totale : " + totalDistance + " km");
        System.out.println("Temps Total : " + totalTime + " minutes");
    }
}
