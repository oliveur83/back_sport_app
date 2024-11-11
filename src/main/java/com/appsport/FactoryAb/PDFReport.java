package com.appsport.FactoryAb;

public class PDFReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating PDF report...");
    }
}