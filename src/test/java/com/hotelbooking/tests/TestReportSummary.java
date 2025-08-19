package com.hotelbooking.tests;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.xml.XmlSuite;
import java.util.List;
import java.util.Map;

public class TestReportSummary implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("\n=========== TEST EXECUTION SUMMARY ===========");
        int totalPassed = 0, totalFailed = 0, totalSkipped = 0;

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult result : suiteResults.values()) {
                totalPassed += result.getTestContext().getPassedTests().size();
                totalFailed += result.getTestContext().getFailedTests().size();
                totalSkipped += result.getTestContext().getSkippedTests().size();
            }
        }

        System.out.println("Total Passed: " + totalPassed);
        System.out.println("Total Failed: " + totalFailed);
        System.out.println("Total Skipped: " + totalSkipped);
        System.out.println("Environment: QA");
        System.out.println("Execution Time: " + java.time.LocalDateTime.now());
        System.out.println("===============================================\n");
    }
}
