package library.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class EngagementSettingFlow extends FDUtils {

    @Test(groups = "diamond", description = "Tested the flow of selecting a Setting. Select the setting, adding diamond, adding to the cart, and completing the checkout flow.")
    public void startWithASetting() throws InterruptedException {

        // Initialize ExtentTest logger for this test method
        ExtentTest logger = getExtentInstance().createTest("Engagement Setting Flow Test");
        test.set(logger);

        FDPageObjectData engagementPage = new FDPageObjectData(driver);

        test.get().info("Started Engagement Setting flow test");

        engagementPage.clickEngagementLink();
        test.get().info("Clicked Engagement link");

        engagementPage.startWithSetting();
        test.get().info("Started flow with a Setting");

        engagementPage.clickRandomProduct(FDPageObjectData.jewelryProductsPLP);
        test.get().info("Clicked on a random product");

        engagementPage.selectRandomBandMaterial();
        test.get().info("Selected random band material");

        engagementPage.ringSizer();
        test.get().info("Used ring sizer");

        engagementPage.bandMaterialDropdown();
        test.get().info("Band material option selected");

        // select if diamond type dropdown  is present in PDP
        engagementPage.handleDiamondTypeIfPresent(test.get());

        engagementPage.selectThisSetting();
        test.get().info("Selected this setting");

        // Note: reusing diamond button properties; works for setting as well
        engagementPage.searchSettingForThisDiamond();
        test.get().info("Searched setting for this diamond");

        //Thread.sleep(4000);

        engagementPage.selectDiamond2();
        test.get().info("Selected diamond");

        //Thread.sleep(1000);

        engagementPage.addStoneToSetting();
        test.get().info("Added stone to setting");

        // Capture cart total before leaving the cart
        String cartTotal = engagementPage.getCartTotalPrice();
      //  test.get().info("Cart Total: " + cartTotal);


// Proceed to checkout
        engagementPage.proceedToCheckout();
        test.get().info("Proceeded to checkout");

// Validate checkout title and price
        engagementPage.checkoutValidation(cartTotal);

        test.get().pass("Engagement Setting flow test completed and validated successfully");

    }
}
