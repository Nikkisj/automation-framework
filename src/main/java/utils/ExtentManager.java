package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path =
                System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config()
                .setReportName("TutorialsNinja Automation");

        reporter.config()
                .setDocumentTitle("Automation Test Results");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Nikita Jadhav");

        return extent;
    }
}