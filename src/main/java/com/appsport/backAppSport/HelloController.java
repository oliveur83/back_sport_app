package com.appsport.backAppSport;

import com.appsport.FactoryAb.ExcelReportFactory;
import com.appsport.FactoryAb.PdfReportFactory;
import com.appsport.FactoryAb.Report;
import com.appsport.FactoryAb.ReportFactory;
import com.appsport.factory.Competition;
import com.appsport.model.Data;
import com.appsport.factory.CompetitionFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appsport.osberver.RecordObserver;
import com.appsport.osberver.SpeedObserver;
import com.appsport.osberver.TrailData;
import com.appsport.singloton.StatisticsManager;
import com.appsport.strategy.ParentCompetition;
import com.appsport.strategy.UltraTrail;
import com.appsport.state.*;
import com.appsport.decorateur.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

    private final TrailData trailData;
    private final CompetitionFactory competitionFactory;
    private final ContexteAnalyse contexteAnalyse;
    private final StatisticsManager statisticsManager;

    public HelloController() {
        this.trailData = new TrailData();
        this.trailData.registerObserver(new SpeedObserver());
        this.trailData.registerObserver(new RecordObserver());

        this.competitionFactory = new CompetitionFactory();

        // Initialisation avec un état par défaut
        this.contexteAnalyse = new ContexteAnalyse(new EtatProgression());
        this.statisticsManager = new StatisticsManager();
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/stategie")
    public String processCompetition(@RequestParam String strategyType) {
        ParentCompetition strategy;

        if ("ultraTrail".equals(strategyType)) {
            strategy = new UltraTrail();
        } else {
            return "Unknown strategy type";
        }

        strategy.typecompetition();

        return "Competition processed with strategy: " + strategyType;
    }

    @GetMapping("/observer")
    public String updateData(@RequestParam double distance, @RequestParam double time) {
        Data data = new Data();
        data.setDistance(distance);
        data.setTime(time);
        trailData.setData(data);

        return "Data updated: distance=" + distance + ", time=" + time;
    }

    @GetMapping("/competition")
    public String competition(@RequestParam String type) {
        Competition competition;
        try {
            competition = competitionFactory.createCompetition(type);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        competition.typeCompetition();
        return "Competition type: " + type;
    }

    @GetMapping("/report")
    public String generateReport(@RequestParam String type) {
        ReportFactory reportFactory;
        switch (type.toLowerCase()) {
            case "pdf":
                reportFactory = new PdfReportFactory();
                break;
            case "excel":
                reportFactory = new ExcelReportFactory();
                break;
            default:
                return "Unknown report type: " + type;
        }

        Report report = reportFactory.createReport();
        report.generate();
        return "Report generated: " + type;
    }

    @GetMapping("/state")
    public String changeState(@RequestParam String stateType, @RequestParam String utilisateur,
            @RequestParam int performances) {
        // Créer des données utilisateur
        Donnees donnees = new Donnees(utilisateur, performances);

        // Changer d'état en fonction du paramètre
        switch (stateType.toLowerCase()) {
            case "progression":
                contexteAnalyse.setEtat(new EtatProgression());
                break;
            case "stagnation":
                contexteAnalyse.setEtat(new EtatStagnation());
                break;
            case "regression":
                contexteAnalyse.setEtat(new EtatRegression());
                break;
            default:
                return "Unknown state type: " + stateType;
        }

        // Exécuter l'analyse dans le nouvel état
        contexteAnalyse.analyser(donnees);

        return "State changed to: " + stateType + " for user: " + utilisateur + " with performances: " + performances;
    }

    @GetMapping("/stats")
    public String showStats(@RequestParam boolean withAltitude, @RequestParam boolean withVitesse) {
        // Créer les statistiques de base
        Statistiques stats = new StatistiquePrincipale();

        // Décorer les statistiques si demandé
        if (withAltitude) {
            stats = new StatAltitude(stats);
        }
        if (withVitesse) {
            stats = new StatVitesse(stats);
        }

        // Capturer la sortie de la méthode afficherStats()
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outputStream));

        // Afficher les statistiques
        stats.afficherStats();

        // Récupérer la sortie et restaurer la sortie standard
        System.out.flush();
        System.setOut(originalOut);
        String statsOutput = outputStream.toString();

        return "Statistiques affichées : <br>" + statsOutput.replace("\n", "<br>");
    }

    // Nouveau endpoint pour le Singleton
    @GetMapping("/singleton/addRun")
    public String addRun(@RequestParam int distance, @RequestParam int time) {
        statisticsManager.addRun(distance, time);
        return "Run added: " + distance + " km in " + time + " minutes.";
    }

    @GetMapping("/singleton/stats")
    public String getSingletonStats() {
        int totalDistance = statisticsManager.getTotalDistance();
        int totalTime = statisticsManager.getTotalTime();
        return "Total Distance: " + totalDistance + " km, Total Time: " + totalTime + " minutes";
    }
}
