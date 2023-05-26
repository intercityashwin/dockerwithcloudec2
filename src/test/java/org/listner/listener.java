package org.listner;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.extentReports.extentReports;
import org.initializeCleanup.initialize;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import java.io.File;
import java.io.IOException;

@Listeners
public class listener implements ITestListener {
    ExtentTest extentTest;
    ExtentReports extentReportsTest = extentReports.getReport();
    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReportsTest.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTestThreadLocal.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTestThreadLocal.get().log(Status.FAIL, "Test Failed");
        try {
            String path = takeScreenShot(result.getMethod().getMethodName());
            extentTestThreadLocal.get().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReportsTest.flush();
    }

    public String takeScreenShot(String testCaseName) throws IOException {
        //String outputFileName = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        String outputFileName = "/usr/share/seleniumdocker/reports/" + testCaseName + ".png";
        TakesScreenshot ts = (TakesScreenshot) initialize.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File(outputFileName));
        return outputFileName;
    }
}
