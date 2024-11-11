package com.appsport.decorateur;

public class StatVitesse extends StatistiquesDeco {

    public StatVitesse(Statistiques stats) {
        super(stats);
    }

    @Override
    public void afficherStats() {
        super.afficherStats();
        afficherVitesse();
    }

    private void afficherVitesse() {
        // Code pour afficher les statistiques de vitesse
        System.out.println("Vitesse actuelle : 12 km/h");
    }
}