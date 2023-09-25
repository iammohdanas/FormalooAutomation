package testcases.FormalooAutomationbyAnas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage {
    public static void scrollToElement(WebDriver driver, By locator, long timeoutInSeconds) {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            WebElement element = driver.findElement(locator);
            if (element != null) {
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                break;
            } else {
                js.executeScript("window.scrollBy(0, 100);");
                js.executeScript("window.scrollBy(0, -100);"); // Scroll up in addition
            }
        }
    }
}
