package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BaseClass {
	
	public MobileElement waitForElementToBeVisible(By locator, int durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static MobileElement findElement(By locator, int durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated((By) locator));
    }
    
    public void scrollUntilElementIsVisible(By locator, int maxScrollAttempts, String resourceId, String text) {
        int scrollAttempts = 0;
        while (scrollAttempts < maxScrollAttempts) {
            try {
                // If the element is visible, break out of the loop
                if (driver.findElement(locator).isDisplayed()) {
                    System.out.println("Element is now visible after scrolling.");
                    break;
                }
            } catch (Exception e) {
                // Perform a scroll gesture to scroll down
                System.out.println("Scrolling attempt: " + (scrollAttempts + 1));
                scrollDown(resourceId, text);
                scrollAttempts++;
            }
        }
    }

    private void scrollDown(String resourceId, String text) {
        String scrollableScript = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().resourceIdMatches(\"%s\").textMatches(\"%s\").instance(0))", resourceId, text);

        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(scrollableScript));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

