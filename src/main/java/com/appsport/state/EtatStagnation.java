package com.appsport.state;

public class EtatStagnation implements EtatAnalyse {
    @Override
    public void analyser(Donnees donnees) {
        System.out.println("L'utilisateur stagne. Analyse des ajustements nécessaires pour briser la stagnation.");
        // Logique d'analyse pour identifier des changements
    }
}
