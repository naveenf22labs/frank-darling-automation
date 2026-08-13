package weddings.library.com;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageobjects.com.FDPageObjectData;
import utils.com.FDUtils;

public class GoldBands extends FDUtils {

    @Test(groups = "Wedding", description = "Tested the flow of Gold Bands. Selecting the gold band ring, adding to the cart and completing checkout flow.")
    public void goldBands() throws InterruptedException {
        
        ExtentTest logger = getExtentInstance().createTest("Gold Bands Flow Test");
        test.set(logger);

        FDPageObjectData goldBandPage = new FDPageObjectData(driver);

        test.get().info("Started Gold Bands flow test");

        goldBandPage.clickWeddingLink();
        test.get().info("Clicked Wedding link");

        goldBandPage.selectGoldBand();
        test.get().info("Selected Gold Band option");

//        goldBandPage.closePopUp();
//        test.get().info("Closed any popup");

        goldBandPage.clickRandomProduct(FDPageObjectData.weddingProductPLP);
        //test.get().info("Clicked random Gold Band product");
//

        goldBandPage.selectRandomMetalType();
        //test.get().info("Selected random band material");

        goldBandPage.ringSizer();
        test.get().info("Selected Random Ring Sizer");

//        //will select stone/diamond type if its present.
        goldBandPage.handleDiamondTypeIfPresent(test.get());
//
        goldBandPage.addToCartButton();
        test.get().info("Added product to cart");
        goldBandPage.completeCheckoutFlow(goldBandPage, test.get());

    }
}
