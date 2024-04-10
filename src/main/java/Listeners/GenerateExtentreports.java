package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class GenerateExtentreports{

    public static ExtentReports generatereport(){
        ExtentSparkReporter configreport=new ExtentSparkReporter(new File("target/extentreprt"));
        configreport.config().setDocumentTitle("KIWI AUTOMATION");
        configreport.config().setTheme(Theme.DARK);
        ExtentReports reports=new ExtentReports();
        reports.attachReporter(configreport);
        return reports;


    }
}
