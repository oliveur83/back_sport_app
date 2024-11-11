package com.appsport.FactoryAb;

public class ExcelReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ExcelReport();
    }
}
