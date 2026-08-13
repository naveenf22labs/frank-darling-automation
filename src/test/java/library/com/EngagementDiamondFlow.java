package library.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class EngagementDiamondFlow extends FDUtils {

    @Test(groups = "diamond", description = "Tested the flow of selecting a diamond. Selecting the diamond, customizing the setting, adding to the cart, and completing the checkout flow.")
    public void startWithADiamond() throws InterruptedException {

        //  Initialize ExtentTest logger
        ExtentTest logger = getExtentInstance().createTest("Engagement Diamond Flow Test");
        test.set(logger);

        FDPageObjectData engagementPage = new FDPageObjectData(driver);

        test.get().info("Started Engagement Diamond flow test");

        engagementPage.clickEngagementLink();
        test.get().info("Clicked on Engagement link");

        engagementPage.startWithDiamond();
        test.get().info("Started flow with a Diamond");

        engagementPage.searchDiamonds();
        test.get().info("Searched for diamonds");



      //  Thread.sleep(3000);

        engagementPage.selectDiamond1();
        test.get().info("Selected a diamond");

        engagementPage.selectThisStone();
        test.get().info("Clicked 'Select This Stone'");

        engagementPage.searchSettingForThisDiamond();
        test.get().info("Searched for setting to match selected diamond");
        Thread.sleep(3000);

        engagementPage.clickRandomProduct(FDPageObjectData.diamondSettingPLP);
        test.get().info("Clicked a random setting product");

        engagementPage.selectRandomMetalType();
       // test.get().info("Selected random band material");

        engagementPage.ringSizer();
        test.get().info("Selected random ring sizer ");

        engagementPage.bandWidthDropdown();
        test.get().info("Selected Band metal");
            // select if diamond type dropdown  is present in PDP
        engagementPage.handleDiamondTypeIfPresent(test.get());

        engagementPage.addSettingToStone();
        test.get().info("Added selected setting to the stone");
        engagementPage.completeCheckoutFlow(engagementPage, test.get());

    }
}
