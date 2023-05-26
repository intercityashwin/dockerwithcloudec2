package org.extentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {

    public static ExtentReports getReport(){
        //String reportPath = System.getProperty("user.dir")+"//reports//testResults.html";
        String reportPath = "/usr/share/seleniumdocker/reports/testResults.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automated Test Results");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
