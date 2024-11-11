package com.appsport.decorateur;

public class StatAltitude extends StatistiquesDeco {

    public StatAltitude(Statistiques stats) {
        super(stats);
    }

    @Override
    public void afficherStats() {
        super.afficherStats();
        afficherAltitude();
    }

    private void afficherAltitude() {
        // Code pour afficher les statistiques d'altitude
        System.out.println("Altitude actuelle : 1500 mètres");
    }
}