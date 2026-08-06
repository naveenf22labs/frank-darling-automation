package jewelry.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class NecklaceWithDefaultDiamond extends FDUtils {

    @Test(groups = "jewelry", description = "Tested the flow of Necklace. Selecting the necklace, adding default diamond to the necklace, then adding to cart and completing the checkout flow.")
    public void NecklaceDefaultDiamondFlow() throws InterruptedException {

        //  Initialize ExtentTest logge
        ExtentTest logger = getExtentInstance().createTest("Necklace with Default Diamond Flow");
        test.set(logger);

        FDPageObjectData necklaces = new FDPageObjectData(driver);

        test.get().info("Started Necklace with Default Diamond flow test");

        necklaces.jewelryNav();
        test.get().info("Navigated to Jewelry section");

        necklaces.selectnecklesOption();
        test.get().info("Selected the Necklaces option");

        necklaces.clickRandomProduct(FDPageObjectData.jewelryProductsPLP);
        //test.get().info("Clicked a random necklace product");

        necklaces.selectRandomBandMaterial();


        necklaces.selectThisNecklaceButton();
        test.get().info("Clicked on 'Select This Necklace' button");

        necklaces.defaultDiamond();
        test.get().info("Selected default diamond");

        necklaces.completeCheckoutFlow(necklaces,  test.get());

//        necklaces.proceedToCheckout();
//        test.get().info("Proceeded to checkout");
//
//        necklaces.checkoutValidation();
//        test.get().pass("Necklace with Default Diamond flow completed successfully");
    }
}
