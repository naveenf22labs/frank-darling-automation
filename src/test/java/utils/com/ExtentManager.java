package utils.com;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            cleanOldReports();

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String reportPath = "test-output/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

    private static void cleanOldReports() {

        File reportDir = new File("test-output");

        if (!reportDir.exists()) {
            return;
        }

        File[] reports = reportDir.listFiles((dir, name) ->
                name.startsWith("ExtentReport_") && name.endsWith(".html"));

        if (reports == null || reports.length < 5) {
            return;
        }

        Arrays.sort(reports, Comparator.comparingLong(File::lastModified));

        int reportsToDelete = reports.length - 4;

        for (int i = 0; i < reportsToDelete; i++)
        {
            if (!reports[i].delete())
            {
                System.out.println("Could not delete report: " + reports[i].getName());
            }
        }
    }
}