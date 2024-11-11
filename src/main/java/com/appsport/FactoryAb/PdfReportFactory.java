package com.appsport.FactoryAb;

public class PdfReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new PDFReport();
    }
}