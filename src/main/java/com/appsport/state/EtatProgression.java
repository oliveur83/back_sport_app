package com.appsport.state;

public class EtatProgression implements EtatAnalyse {
    @Override
    public void analyser(Donnees donnees) {
        System.out.println("L'utilisateur est en progression. Analyse axée sur l'amélioration continue.");
        // Logique d'analyse spécifique pour l'amélioration des performances
    }
}