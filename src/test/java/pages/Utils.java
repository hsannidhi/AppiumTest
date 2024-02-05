package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
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

}
