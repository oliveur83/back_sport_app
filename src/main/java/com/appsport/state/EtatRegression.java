package com.appsport.state;

public class EtatRegression implements EtatAnalyse {
    @Override
    public void analyser(Donnees donnees) {
        System.out.println("L'utilisateur régresse. Analyse des causes de la régression.");
        // Logique pour détecter les causes de la régression (blessures, fatigue, etc.)
    }
}
