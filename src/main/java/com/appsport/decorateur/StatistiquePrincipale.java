package com.appsport.decorateur;

public class StatistiquePrincipale extends Statistiques {

    @Override
    public void afficherStats() {
        // Code pour afficher les statistiques de base
        System.out.println("Statistiques de base :");
        System.out.println("Temps total : 2 heures 30 minutes");
        System.out.println("Distance totale : 25 km");
    }
}
