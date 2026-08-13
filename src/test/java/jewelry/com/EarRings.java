package jewelry.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class EarRings extends FDUtils
{

    @Test(groups = "jewelry", description = "Verifying the functionality of Earring. Selecting the studd, adding to the cart and completing checkout flow.")
    public void jewelryEarRingFlow() throws InterruptedException {
        
        //  Initialize ExtentTest for this test
        ExtentTest logger = getExtentInstance().createTest("Jewelry Earring Flow Test");
        test.set(logger);

        FDPageObjectData earRings = new FDPageObjectData(driver);

        test.get().info("Starting Earring flow test");

        earRings.jewelryNav();
        test.get().info("Navigated to Jewelry section");

        earRings.earRingsOption();
        test.get().info("Selected the Earring category");

        earRings.clickRandomProduct(FDPageObjectData.jewelryProductsPLP);

        earRings.selectRandomMetalType();
       // test.get().info("Selected random band material for earring");

        earRings.totalCaratWeight();
        test.get().info("Selected total carat weight");

        //If required we can use this method, for now not required.
//        earRings.stoneType();
//        test.get().info("Selected stone type");

        earRings.addToCartButton();
        test.get().info("Clicked on Add to Cart");

        earRings.completeCheckoutFlow(earRings, test.get());
//        // Capture cart total before leaving the cart
//        String cartTotal = earRings.getCartTotalPrice();
//        //  test.get().info("Cart Total: " + cartTotal);
//
//
//// Proceed to checkout
//        earRings.proceedToCheckout();
//        test.get().info("Proceeded to checkout");
//
//// Validate checkout title and price
//        earRings.checkoutValidation(cartTotal);

//        earRings.proceedToCheckout();
//        test.get().info("Proceeded to Checkout");
//
//        earRings.checkoutValidation();
//        test.get().pass("Checkout validation completed successfully");
    }
}
