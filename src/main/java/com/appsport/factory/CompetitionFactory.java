package com.appsport.factory;

public class CompetitionFactory {

    public Competition createCompetition(String type) {
        switch (type.toLowerCase()) {
            case "ultratrail":
                return new UltraTrail();
            case "marathon":
                return new Marathon();
            default:
                throw new IllegalArgumentException("Unknown competition type: " + type);
        }
    }
}
