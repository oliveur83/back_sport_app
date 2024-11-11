package com.appsport.state;

public class ContexteAnalyse {
    private EtatAnalyse etat;

    public ContexteAnalyse(EtatAnalyse etat) {
        this.etat = etat;
    }

    public void setEtat(EtatAnalyse etat) {
        this.etat = etat;
    }

    public void analyser(Donnees donnees) {
        if (etat != null) {
            etat.analyser(donnees);
        } else {
            System.out.println("Aucun état défini.");
        }
    }
}