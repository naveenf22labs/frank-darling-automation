package weddings.library.com;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkFind {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        List<String> urls = Arrays.asList(
                "https://frankdarling.com/wedding-rings/mens-wedding-bands/"
        );

        for (String url : urls) {
            driver.get(url);

            Thread.sleep(5000);

            // Scroll to bottom (VERY IMPORTANT)
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);

            List<WebElement> faqs = driver.findElements(By.cssSelector("details"));

            System.out.println("Total FAQs: " + faqs.size());

            for (WebElement faq : faqs) {

                try {
                    faq.click();
                    Thread.sleep(1000);
                } catch (Exception e) {}

                String fullText = faq.getText();

                List<WebElement> links = faq.findElements(By.tagName("a"));

                if (!links.isEmpty()) {
                    for (WebElement link : links) {
                        System.out.println("Page: " + url);
                        System.out.println("FAQ: " + fullText);
                        System.out.println("Link Text: " + link.getText());
                        System.out.println("URL: " + link.getAttribute("href"));
                        System.out.println("------");
                    }
                }
            }
        }

        driver.quit();
    }
}