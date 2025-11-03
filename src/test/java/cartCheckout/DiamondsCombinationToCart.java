package cartCheckout;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class DiamondsCombinationToCart extends FDUtils {

    @Test(groups = "CartCheckoutTestCases", description = "Removing added diamonds i.e, normal and default diamond from the cart.")
    public void defaultDiamondAndNormalDiamonds() throws InterruptedException 
    {
    	 ExtentTest logger = getExtentInstance().createTest("Diamond combination Flow Test");
         test.set(logger);
        FDPageObjectData cart = new FDPageObjectData(driver);

        test.get().info("Navigated to Jewelry section");

        // Adding normal diamond to the cart.
        test.get().info("Clicking on Engagement link.");
        cart.clickEngagementLink();

        test.get().info("Starting with diamond.");
        cart.startWithDiamond();

        test.get().info("Searching for diamonds.");
        cart.searchDiamonds();

        test.get().info("Closing popup if present.");
        cart.closePopUp();

        test.get().info("Selecting the first diamond.");
        cart.selectDiamond1();

        test.get().info("Selecting this stone.");
        cart.selectThisStone();

        test.get().info("Searching for settings for the selected diamond.");
        cart.searchSettingForThisDiamond();

        test.get().info("Clicking a random product from diamond setting PLP.");
        cart.clickRandomProduct(FDPageObjectData.diamondSettingPLP);

        test.get().info("Selecting a random band material.");
        cart.selectRandomBandMaterial();

        cart.ringSizer();
        test.get().info("Used ring sizer option");
        cart.bandMaterialDropdown();
        test.get().info("User selects Band material option");
        // select if diamond type dropdown  is present in PDP
        cart.handleDiamondTypeIfPresent(test.get());

        test.get().info("Adding setting to the stone.");
        cart.addSettingToStone();

        // Adding default diamond to the cart
        test.get().info("Clicking on Engagement link again.");
        cart.clickEngagementLink();

        test.get().info("Starting with setting.");
        cart.startWithSetting();

        test.get().info("Clicking a random product from diamond setting PLP.");
        cart.clickRandomProduct(FDPageObjectData.diamondSettingPLP);

        test.get().info("Selecting a random band material.");
        cart.selectRandomBandMaterial();
        cart.ringSizer();
        test.get().info("Used ring sizer");

        cart.bandMaterialDropdown();
        test.get().info("Band material option selected");

        // select if diamond type dropdown  is present in PDP
        cart.handleDiamondTypeIfPresent(test.get());
        test.get().info("Selecting this setting.");
        cart.selectThisSetting();

        test.get().info("Adding default diamond.");
        cart.defaultDiamond();

        Thread.sleep(3000);

        test.get().info("Focusing on cart.");
        cart.cartFocusUp();

        test.get().info("Removing all products from cart.");
        cart.removeAllProductsFromCart();
        //required to check all products should removed.

        // Uncomment if needed
        // cart.removeProductFromCart(1);
    }
}
