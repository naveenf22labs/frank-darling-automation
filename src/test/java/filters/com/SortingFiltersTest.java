package filters.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class SortingFiltersTest extends FDUtils {

    @Test(groups = "Filters", dataProvider = "sortOptions", dataProviderClass = filters.data.FilterDataProvider.class)
    public void startWithASetting(String option) throws InterruptedException
    {

        // Initialize ExtentTest logger for this test method
        ExtentTest logger = getExtentInstance().createTest("Sort Filter - " + option);

        test.set(logger);

        FDPageObjectData engagementPage = new FDPageObjectData(driver);

        test.get().info("Started Engagement Setting flow test");

        engagementPage.clickEngagementLink();
        test.get().info("Clicked Engagement link");

        engagementPage.startWithSetting();
        test.get().info("Started flow with a Setting");

//        engagementPage.clickSortDropdown();
//        test.get().info("Clicked Sort dropdown");

        engagementPage.selectSortOption(option);
        test.get().info("Selected sort option");
        //Thread.sleep(3000);

    }

}
