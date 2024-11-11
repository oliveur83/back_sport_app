package com.appsport.decorateur;

public abstract class StatistiquesDeco extends Statistiques {
    protected Statistiques stats;

    public StatistiquesDeco(Statistiques stats) {
        this.stats = stats;
    }

    @Override
    public void afficherStats() {
        stats.afficherStats();
    }
}