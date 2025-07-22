package utils.com;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class FDUtils
{
	
	public static WebDriver driver;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extent;

    // Initialize ExtentReports instance
    public static ExtentReports getExtentInstance() {
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }
        return extent;
    }

	@BeforeMethod(alwaysRun = true)
	public void launchUrl()
	{
		//System.out.println(" Launching browser in @BeforeMethod");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");
		// options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
        	options.addArguments("--disable-dev-shm-usage");
        	options.addArguments("--window-size=1920,1080");
		
		 driver=new ChromeDriver(options);
	  //  driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080)); // Set size for Full HD resolution

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://frankdarling.com");
		// System.out.println("Driver initialized: " + driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownAndClose(ITestResult result) {
		ExtentTest logger = test.get(); // Get the test instance for the current thread

		// Log based on result status
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed: " + result.getThrowable());
			ScreenshotUtil.captureScreenshot(driver, result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped: " + result.getThrowable());
		}

		// Quit driver
		if (driver != null) {
			driver.quit();
		}

	}

	@AfterSuite(alwaysRun = true)
	public void flushReport() {
		getExtentInstance().flush();
	}


}
