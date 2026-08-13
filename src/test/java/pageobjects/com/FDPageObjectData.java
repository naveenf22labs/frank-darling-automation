package pageobjects.com;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import static utils.com.FDUtils.test;

public class FDPageObjectData
{

    public WebDriver driver;
    
    public By engagementLink = By.xpath("//span[text()='Engagement']");
    
    public By startWithDiamondOption = By.xpath("//span[text()='Start with a diamond']");
    
    public By startWithSettingOption = By.xpath("//span[text()='Start with a setting']");
    private By defaultDiamondXpath = By.xpath("//div[text()='Continue with the default diamond stone']");
 
    public By searchDiamondsOption = By.xpath("//span[text()='SEARCH DIAMONDS']");
    public By reamazeWidgetIcon = By.id("reamaze-widget-icon");
    public By closePopUpButton = By.xpath("//button[@aria-label='Close dialog']");
   // public By closePopUpButton = By.className("klaviyo-close-form");
    public By diamondRow = By.xpath("(//div[starts-with(@name, 'diamond-row')])[1]"); //start with a flow diamond
    public By diamondRowForSetting=By.xpath("(//div[starts-with(@name, 'diamond')])[1]");// Start with a setting flow
    public By selectThisStoneButton = By.xpath("(//button[text()='Select this stone'])[1]");
    public By searchSettingButton = By.xpath("//button[@type='button' and @variant='primary']");
    public By harperRingLink = By.xpath("//a[text()='The Harper ']");
    public By addSettingToStoneButton = By.xpath("//div[text()='Add Setting to Stone']");
    public By addStoneToSettingButton = By.xpath("(//button[text()='Add stone to setting'])[1]");

    public By selectThisSettingButton = By.xpath("//div[text()='Select This Setting']");

    public By checkoutButton = By.xpath("//button[text()='Checkout']");
    //----------------------------------- Wedding properties------------------
    private By weddingtLink = By.xpath("//span[text()='Wedding']");
    private By menWeddingbandXPath = By.xpath("//span[text()='Mens Wedding Bands']");
    private By menWeddingPlp= By.xpath("//a[text()='The Rigatoni']");

    private By addToCartXpath=By.xpath("//div[text()='Add To Cart']");
    
    private By anniversaryXpath=By.xpath("//span[text()='Anniversary Rings']");
    private By  anniversaryPlpXpath=By.xpath("//a[text()='The Round Scallop Eternity 3mm']");
    
    private By stackingRingsXpath=By.xpath("//span[text()='Stacking Rings']");
    private By stackingPlpXpath=By.xpath("//a[text()='The Skinny Eternity']");

    private By  diamondBandXpath=By.xpath("//span[text()='Diamond Bands']");
    
    private By diamondBandPlp=By.id("wedding-rings-1");
    
    private By eternityBandXpath=By.xpath("//span[text()='Eternity Bands']");
    private By goldBandXpath=By.xpath("//span[text()='Gold Bands']");
    //---------------------Jewelry--------------------
    
    private By jewelryXpath=By.xpath("//span[text()='Jewelry']");
    private By earRingsXpath=By.xpath("//span[text()='Earrings']");
    
    private By earRingsPlp=By.xpath("//div[contains(@class,'w-vw-1/2 h') and contains(@id,'engagement-rings')]");
    
    private By necklesXpath=By.xpath("//span[text()='Necklaces']");
    private By necklaceButtonXpath=By.xpath("//div[text()='Select This Necklace']");
    
    private By selectDiamondForNecklace=By.xpath("(//div[starts-with(@name, 'diamond')])[1]");
    
        
    private By  addDiamondToNecklaceButtonXpath= By.xpath("(//button[text()='Add diamond to necklace'])[1]");
    private By tennisNecklaceXpath=By.xpath("(//span[text()='Tennis Bracelets'])[1]");
    private By giftGuideXpath=By.xpath("//span[text()='Gift Guide']");
    private By  giftGuidePlp=By.xpath("(//button[@value='Continue'])[5]");
    
    //Cart                  
    private By  closeCartXpath= By.xpath("//button[@aria-label='Close cart']");
    
    private By globalPlp=By.id("engagement-rings-1");
    private By cartFocus= By.xpath("(//div[@role='dialog'])[4]");
   
    // driver.findElement(By.tagName("a"));
    
    public void cartFocusUp() throws InterruptedException
    {
    	WebElement cartElement = driver.findElement(cartFocus);

    	// Create an instance of JavascriptExecutor
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	js.executeScript("arguments[0].scrollTop = 0;", cartElement);
    	js.executeScript("arguments[0].scrollIntoView(true);", cartElement);
    
    }
  
    private By cartProductRemoval(int index) 
    {
        return By.xpath("(//span[@class='mr-1.5 cursor-pointer']//*[name()='svg'])[" + index + "]");
    }
// New Removal code
   // private By allCartRemoveIcons=By.xpath("(//span[contains(@class,'mr-1.5')])");
    By allCartRemoveIcons = By.xpath("//div[contains(@class,'flex items-center')]//*[name()='svg' and contains(@class,'w-6')]"
    );

By cartContainer = By.xpath("//div[@role='dialog' and contains(@class,'overflow-y-scroll')]");

    public void removeAllProductsFromCart() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement cart = driver.findElement(cartContainer);

        js.executeScript("arguments[0].scrollTop = 100;", cart);

        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int removedCount = 0;

        while (true) {

            List<WebElement> removeIcons = driver.findElements(allCartRemoveIcons);

            if (removeIcons.isEmpty()) {
                break;
            }

            int currentSize = removeIcons.size();

            WebElement removeButton = removeIcons.get(0);

            js.executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    removeButton
            );

            wait.until(ExpectedConditions.elementToBeClickable(removeButton));

            removeButton.click();

            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                    allCartRemoveIcons,
                    currentSize
            ));

            removedCount++;
        }

        System.out.println("Total products removed from cart: " + removedCount);
    }
    //New Removal code
    public boolean isCartEmpty() {
        return driver.findElements(allCartRemoveIcons).isEmpty();
    }
   public void removeProductFromCart(int index) throws InterruptedException 
    {
    	for (int i=1; i<=3;  i++)
    	{
    		  driver.findElement(cartProductRemoval(index)).click();
    		 //Thread.sleep(2000);

    	}
              
    }
  
  // public WebDriver driver;
   public FDPageObjectData(WebDriver driver) {
       this.driver = driver;
   }

    public void clickEngagementLink() {
        driver.findElement(engagementLink).click();
    }

    public void startWithDiamond() {
        driver.findElement(startWithDiamondOption).click();
    }

    public void searchDiamonds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchDiamondsOption)).click();
    }

    public void doubleClickReamazeWidget() throws InterruptedException {
        WebElement element = driver.findElement(reamazeWidgetIcon);
        Actions act = new Actions(driver);
        act.click(element).perform();
        Thread.sleep(2000);
       act.click().build().perform();
       //Thread.sleep(2000);

       
    }

    public void closePopUp() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closePopUp = wait1.until(ExpectedConditions.elementToBeClickable(closePopUpButton));
        closePopUp.click();
    }
    //Start with a Diamond flow
    public void selectDiamond1() {
       // driver.findElement(diamondRow).click();
        safeClick(diamondRow);
    }

    public void selectDiamond2() {
        safeClick(diamondRowForSetting);
    }

    public void selectThisStone()
{
    safeClick(selectThisStoneButton);
}
    //select this setting button 
    public void selectThisSetting() {
    	driver.findElement(selectThisSettingButton).click();
    }
    public void searchSettingForThisDiamond()
            {
                safeClick(searchSettingButton);
            }
    
    public void defaultDiamond()
    {
    	driver.findElement(defaultDiamondXpath).click();
    }

    public void selectHarperRing() {
        driver.findElement(harperRingLink).click();
    }

        public void addSettingToStone()
        {
            safeClick(addSettingToStoneButton);
        }

    public void addStoneToSetting()
    {
        safeClick(addStoneToSettingButton);
    }

By cartTotalPrice = By.id("cart-total-price");

    public String getCartTotalPrice() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotalPrice))
                .getText()
                .trim();
    }
    By checkoutTotalPrice = By.xpath("//span[normalize-space()='USD']/following::strong[2]");
    public String getCheckoutTotalPrice() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutTotalPrice))
                .getText()
                .trim();
    }
public void proceedToCheckout()
{
    safeClick(checkoutButton);
}
    
    public void startWithSetting()
    {
    	driver.findElement(startWithSettingOption).click();
    }



    public void checkoutValidation(String cartTotal)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait until checkout page is loaded
        wait.until(ExpectedConditions.titleIs("Checkout - FD"));

        // Validate page title
        Assert.assertEquals(driver.getTitle(), "Checkout - FD");

        // Get checkout total
        String checkoutTotal = getCheckoutTotalPrice();

        // Print in console
        System.out.println("Cart Total      : " + cartTotal);
        System.out.println("Checkout Total  : " + checkoutTotal);

        // Log in Extent Report
        test.get().info("Cart Total: " + cartTotal);
        test.get().info("Checkout Total: " + checkoutTotal);

        // Validate prices
        Assert.assertEquals(checkoutTotal, cartTotal,
                "Cart Total and Checkout Total do not match.");

        test.get().pass("Price validation successful.");

    }

    public void checkoutValidation() throws InterruptedException
    {
        Thread.sleep(3000);

    	System.out.println(driver.getTitle());
    	String expectedTitle="Checkout - FD";
    	String currentTitle=driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle);
  }
    public void completeCheckoutFlow(FDPageObjectData page, ExtentTest test) throws InterruptedException {

        String cartTotal = page.getCartTotalPrice();
       // test.info("Cart Total: " + cartTotal);

        page.proceedToCheckout();
        test.info("Proceeded to checkout");
       Thread.sleep(2000);
        page.checkoutValidation(cartTotal);
        test.pass("Checkout validation completed");
    }

    //-------------------Wedding properties-----------------
	  //Selecting wedding from nav
    public void clickWeddingLink()
    {
    	driver.findElement(weddingtLink).click();
    }
	  //Selecting Men Wedding bands option from Wedding
    public void selectMenWeddingoption()
    {
    	driver.findElement(menWeddingbandXPath).click();
    }
    
    public void SelectingMenWeddingPlp()
    {
    	driver.findElement(menWeddingPlp).click();
    }
    
    public void addToCartButton()
    {
    	driver.findElement(addToCartXpath).click();
    }
    //Anniversary option clicking from wedding navigation
    public void selectAnniversaryOption()
    {
    	driver.findElement(anniversaryXpath).click();
    }

    public void selectAnniversaryPlp()
    {
    	driver.findElement(anniversaryPlpXpath).click();
    }
    
    public void stackingRings() 
    {
    	driver.findElement(stackingRingsXpath).click();
    	
    }
    public void stackingRingsplp()
    {
    	driver.findElement(stackingPlpXpath).click();
    }
    public void selectDiamondBand() 
    {
    	driver.findElement(diamondBandXpath).click();
    	
    }
    //can use same id locator to enternity plp as well bcz both are same.
    public void selectDiamondBandProduct()
    {
    	driver.findElement(diamondBandPlp).click();
    }
    public void selectEternityBand() 
    {
    	driver.findElement(eternityBandXpath).click();
    }
    public void  selectGoldBand()
    {
    	driver.findElement(goldBandXpath).click();
    }
    //-----------------------------------------------Jewelry--------------------------
    

public void jewelryNav() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    WebElement jewelry = wait.until(
            ExpectedConditions.elementToBeClickable(jewelryXpath));

    jewelry.click();
}
    public void earRingsOption()
    {
    	driver.findElement(earRingsXpath).click();
    }
    public void jewleryPlp()
    {

    	driver.findElement(earRingsPlp).click();
    }
    public void selectnecklesOption()
    {
    	driver.findElement(necklesXpath).click();
    }

public void selectThisNecklaceButton()
{
    safeClick(necklaceButtonXpath);
}
public void selectDiamondFromNecklacesPlp()
{
    safeClick(selectDiamondForNecklace);
}
public void addDiamondToNecklaceButton()
{
    safeClick(addDiamondToNecklaceButtonXpath);
}
    public void selectTennisNecklace()
    {
    	driver.findElement(tennisNecklaceXpath).click();
    }
    
    public void giftGuide() 
    {
    	driver.findElement(giftGuideXpath).click();
    	
    }
    public void selectGiftGuidePlp() 
    {
    driver.findElement(giftGuidePlp).click();	
    }

    
    public void closeCart() throws InterruptedException
    {
    	
    	
    	// Initialize WebDriverWait
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	// Wait for the element to be visible
    	WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(closeCartXpath));

    	// Scroll the element into view to ensure it's visible in the viewport
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	// Wait for the element to be clickable
    	wait.until(ExpectedConditions.elementToBeClickable(cart));

    	// Now click the element
    	//cart.click();
    	js.executeScript("arguments[0].click();", cart);

    	
    }
    public void globalPLPRing()
    {
    	driver.findElement(globalPlp).click();
    }
          
    
    // random product selection code for weddings
  //  private By productItems=By.xpath("//div[@id='ring-container']");
  public static  By weddingProductPLP=By.xpath("//a[contains(@class,'absolute inset-0 z-[2] block')]");
  
  public static By jewelryProductsPLP = By.xpath("//a[contains(@class,'absolute inset-0')]");
   
  
  //Diamond setting PLP
  public static By diamondSettingPLP = By.xpath("//a[contains(@class,'absolute inset-0 ')]");


      //Method to get the list of product items
    public List<WebElement> getProductList(By productLocator) 
    {
     return driver.findElements(productLocator);
     
    }
public void scrollToEndOfPage() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Scroll down by a small amount (e.g. 800 pixels)
    js.executeScript("window.scrollBy(0, 700);");

    // Wait briefly to allow UI to adjust or images to load
    Thread.sleep(300);
}
    //Method to select a random product from the PLP
      public WebElement selectRandomProduct(By productLocator)
      {
          List<WebElement> products = getProductList(productLocator);
          System.out.println("Products found "+ products.size());
          if(products.isEmpty()){
              throw new RuntimeException("No products found for locator "+productLocator );
          }
           Random rand = new Random();
           int randomIndex = rand.nextInt(products.size());
             return products.get(randomIndex);
     }

    private By productNameInPdp=By.xpath("//h2[contains(@class,'font-serif') and contains(@class,'text-lg')]");

    public void clickRandomProduct(By productLocator) throws InterruptedException {

        scrollToEndOfPage();

        List<WebElement> products = getProductList(productLocator);

        if (products.isEmpty()) {
            throw new RuntimeException("No products found.");
        }

        int randomIndex = new Random().nextInt(products.size());

        WebElement product = products.get(randomIndex);

        for (int i = 0; i < 3; i++) {

            try {

                closePopupIfPresent();

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", product);

                product.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                String productName = wait
                        .until(ExpectedConditions.visibilityOfElementLocated(productNameInPdp))
                        .getText()
                        .trim();

                test.get().info("Selected random product: " + productName);


                return;


            }

            catch (ElementClickInterceptedException e) {

                closePopupIfPresent();

            }

            catch (StaleElementReferenceException e) {

                products = getProductList(productLocator);

                product = products.get(randomIndex);

            }

        }

        throw new RuntimeException("Unable to click random product.");

    }
   



    //booking dropdowns
    private By appointmentsXpath=By.xpath("//span[text()='Showrooms']");
    
    public void showrooms()
    {
    	driver.findElement(appointmentsXpath).click();
    	
    }
    private By virtualAppointment=By.xpath("//span[text()='Book a Virtual Appointment']");
    public void virtualAppointments()
    {
    	driver.findElement(virtualAppointment).click();
    	
    }
    
    // selecting random dropdown elements for products in pdp.
   // private By bandMaterialDropdownSelector=By.xpath("(//select[@name='bandSelector'])[2]");
    //input[@type="radio"]
    private By tennisLength=By.xpath("//select[@id='total-length']");
    private By ringSize=By.xpath("//select[@id='ring-size']");
    private By caratWeight=By.xpath("//select[@id='total-carat-weight']");
    private By stoneTypeXpath=By.xpath("//select[@id='diamond-type']");
    private By bandMaterialDropdownSelector=By.xpath("//input[@type='radio']");
    private By bandWidthDropdownSelector=By.xpath("//select[@id='band-width']");


    // adding random selction method for radius options

    public void selectRandomRadioOption(By radioLocator, String optionGroupName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> radioLabels = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class,'flex')]//label[input[@type='radio']]")
        ));

        if (radioLabels.isEmpty()) {
            System.out.println("No radio options found for " + optionGroupName);
            return;
        }

        WebElement randomLabel = radioLabels.get(new Random().nextInt(radioLabels.size()));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomLabel);
        randomLabel.click();

        // Get the value from the nested input
        WebElement input = randomLabel.findElement(By.xpath(".//input[@type='radio']"));
        String value = input.getAttribute("value");
        test.get().info("Selected " + optionGroupName + ": " + value);

       // System.out.println("Selected random option for " + optionGroupName + ": " + value);
    }
    public void selectRandomMetalType() {
        selectRandomRadioOption(bandMaterialDropdownSelector, "Random Band Metal");
    }

public void selectRandomOption(By dropdownLocator, String dropdownName) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        Select dropdown = new Select(dropdownElement);

        // Filter only enabled options
        List<WebElement> enabledOptions = dropdown.getOptions()
                .stream()
                .filter(WebElement::isEnabled)
                .toList();

        if (enabledOptions.isEmpty()) {
            System.out.println("No enabled options found for " + dropdownName);
            return;
        }

        // Pick a random enabled option
        WebElement randomOption = enabledOptions.get(new Random().nextInt(enabledOptions.size()));
        dropdown.selectByVisibleText(randomOption.getText());

        System.out.println("Selected random option for " + dropdownName + ": " + randomOption.getText());

    } catch (Exception e) {
        System.out.println("Error selecting random option for " + dropdownName + ": " + e.getMessage());
    }
}

    public void ringSizer() {
        selectRandomOption(ringSize, "Ring Size");
    }

    public void tennisTotalLength() {
        selectRandomOption(tennisLength, "Tennis Length");
    }
    public void totalCaratWeight() {
    	selectRandomOption(caratWeight, "Total carat weight");
    }
    public void stoneType()
    {
    	selectRandomOption(stoneTypeXpath, "StoneType");
    }

    public void bandWidthDropdown()
    {
        selectRandomOption(bandWidthDropdownSelector, "BandWidth");
    }
    public void handleDiamondTypeIfPresent(com.aventstack.extentreports.ExtentTest testLogger) {
        try {
            List<WebElement> diamondTypeElements = driver.findElements(By.xpath("//label[text()='Diamond Type']"));

            if (!diamondTypeElements.isEmpty()) {
                testLogger.info("'Diamond Type' section found. Performing stoneType()...");
                diamondTypeElements.get(0).click();
                stoneType(); // calling your existing method
            } else {
                testLogger.info("'Diamond Type' section not found. Skipping stoneType() step.");
            }
        } catch (Exception e) {
            testLogger.warning("An error occurred while checking for 'Diamond Type': " + e.getMessage());
        }
    }
    // ==========================
// Close Klaviyo popup if present
// ==========================
    private void closePopupIfPresent() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            WebElement closeButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//button[@aria-label='Close dialog']")
                    ));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", closeButton);

            System.out.println("Popup closed.");

        }
        catch (TimeoutException e) {

            // Popup not displayed.
        }
        catch (Exception e) {

            System.out.println("Unable to close popup: " + e.getMessage());

        }

    }


    // ==========================
// Safe Click Method
// ==========================
    public void safeClick(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        for (int i = 0; i < 3; i++) {

            try {

                closePopupIfPresent();

                WebElement element = wait.until(
                        ExpectedConditions.elementToBeClickable(locator));

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

                element.click();

                return;

            }

            catch (ElementClickInterceptedException e) {

                closePopupIfPresent();

            }

            catch (TimeoutException e) {

                closePopupIfPresent();

            }

            catch (StaleElementReferenceException e) {

            }

        }

        throw new RuntimeException("Unable to click: " + locator);
    }

    private By sortDropdown =By.xpath("//div[text()='Recommended']");
   // private By sortDropdown = By.xpath("//div[text()='Recommended']");
   public void selectSortOption(String option) {

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // Open sort dropdown
       wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)).click();

       // Select required option
       By optionLocator = By.xpath("//span[normalize-space()='" + option + "']");

       wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();

   }
}

