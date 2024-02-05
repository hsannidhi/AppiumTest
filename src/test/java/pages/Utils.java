package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

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
    
    public void scrollUntilLeagueNameIsVisible(By locator, int maxScrollAttempts, String leagueName) {
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
                scrollDown(locator, leagueName);
                scrollAttempts++;
            }
        }
    }

    private void scrollDown(By locator, String leagueName) {
        String scrollableScript = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().resourceIdMatches(\"com.fivemobile.thescore:id/txt_name\").textMatches(\"%s\").instance(0))", leagueName);

        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(scrollableScript));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

