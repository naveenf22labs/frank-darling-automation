package utils.com;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class FDUtils {

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
	public void launchUrl() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");

		boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

		if (headless) {
			options.addArguments("--headless=new");
		}

		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--force-device-scale-factor=1");
		options.addArguments("--high-dpi-support=1");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		driver = new ChromeDriver(options);

		// Force desktop viewport
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().deleteAllCookies();

		System.out.println("Window Size: " + driver.manage().window().getSize());

		String environment = System.getProperty("env", "production");

		if (environment.equalsIgnoreCase("staging"))
		{
			driver.get("https://staging.frankdarling.xyz/");
		} else
		{
			driver.get("https://frankdarling.com");
		}
		// Wait for homepage to load
		Thread.sleep(3000);

		// Capture homepage screenshot for GitHub debugging
		ScreenshotUtil.captureScreenshot(driver, "HomePage");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownAndClose(ITestResult result) {

		ExtentTest logger = test.get();

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed: " + result.getThrowable());
			ScreenshotUtil.captureScreenshot(driver, result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped: " + result.getThrowable());
		}

		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void flushReport() {
		ExtentManager.getInstance().flush();
	}
}