package com.appsport.state;

public class Donnees {
    private String nomUtilisateur;
    private int performancesActuelles;

    public Donnees(String nomUtilisateur, int performancesActuelles) {
        this.nomUtilisateur = nomUtilisateur;
        this.performancesActuelles = performancesActuelles;
    }

    // Getters et Setters

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public int getPerformancesActuelles() {
        return performancesActuelles;
    }

    public void setPerformancesActuelles(int performancesActuelles) {
        this.performancesActuelles = performancesActuelles;
    }
}
