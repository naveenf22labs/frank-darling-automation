package weddings.library.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class EternityBand extends FDUtils {

    @Test(groups = "Wedding", description = "Tested the flow of Eternity band. Selecting the Eternity Ring, adding to the cart and completing the checkout flow.")
    public void eternityBandFlow() throws InterruptedException {

        // Initialize ExtentTest logger
        ExtentTest logger = getExtentInstance().createTest("Eternity Band Flow Test");
        test.set(logger);

        FDPageObjectData eternityBand = new FDPageObjectData(driver);

        test.get().info("Started Eternity Band flow test");

        eternityBand.clickWeddingLink();
        test.get().info("Clicked Wedding link");

        eternityBand.selectEternityBand();
        test.get().info("Selected Eternity Band option");

        eternityBand.closePopUp();
        test.get().info("Closed any popup");

        eternityBand.clickRandomProduct(FDPageObjectData.weddingProductPLP);
        test.get().info("Clicked random Eternity Band product");

        // eternityBand.selectDiamondBandProduct();

//        eternityBand.selectRandomBandMaterial();
//        test.get().info("Selected random band material");

        eternityBand.ringSizer();
        test.get().info("Used ring sizer");
        eternityBand.stoneType();
        test.get().info("Selecting the stone type");

        eternityBand.addToCartButton();
        test.get().info("Added product to cart");

        eternityBand.proceedToCheckout();
        test.get().info("Proceeded to checkout");

        eternityBand.checkoutValidation();
        test.get().pass("Eternity Band flow test completed and validated successfully");
    }
}
