package weddings.library.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class StackingRings extends FDUtils {

    @Test(groups = "Wedding", description = "Tested the flow of Stacking Rings. Selecting the Stacking ring, adding to the cart and completing the checkout.")
    public void stackingRingsFlow() throws InterruptedException {
        
        // Initialize ExtentTest logger for this test
        ExtentTest logger = getExtentInstance().createTest("Stacking Rings Flow Test");
        test.set(logger);
        
        FDPageObjectData stacking = new FDPageObjectData(driver);

        test.get().info("Started Stacking Rings flow test");

        stacking.clickWeddingLink();
        test.get().info("Clicked Wedding link");

        stacking.stackingRings();
        test.get().info("Selected Stacking Rings option");

        stacking.clickRandomProduct(FDPageObjectData.weddingProductPLP);
       // test.get().info("Clicked random Stacking Ring product");

        stacking.selectRandomMetalType();


        stacking.ringSizer();
        test.get().info("Selected Random Ring sizer");
        // will select if stone type is present.
        stacking.handleDiamondTypeIfPresent(test.get());

        stacking.addToCartButton();
        test.get().info("Added product to cart");

        stacking.completeCheckoutFlow(stacking, test.get());
    }
}
