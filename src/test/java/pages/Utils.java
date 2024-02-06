package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utils extends BaseClass {
	
	public MobileElement waitForElementToBeVisible(By locator, int durationInSeconds) {
		// Explicitly wait for an element to be visible
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
	        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    } catch (TimeoutException e) {
	        throw new RuntimeException("Element not visible within the specified timeout: " + e.getMessage());
	    }
	}

	public static MobileElement findElement(By locator, int durationInSeconds) {
		// Find an element by it's locator
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
	        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated((By) locator));
	    } catch (TimeoutException e) {
	        throw new RuntimeException("Element not found within the specified timeout: " + e.getMessage());
	    }
	}
	
	public static List<MobileElement> findElements(String locator, int durationInSeconds) {
		// Find multiple elements
		WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        List<WebElement> webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
        return webElements.stream().map(element -> (MobileElement) element).collect(Collectors.toList());
    }
	
	public void allowLocationPermission() {
		// Allow location permission
		MobileElement allowLocationButton = waitForElementToBeVisible(MobileBy.id(Locators.LOCATION_ACCESS_ALLOW_BUTTON_ID), 10);
        allowLocationButton.click();
        System.out.println("Allow Location button tapped");
        MobileElement locationPermission = waitForElementToBeVisible(MobileBy.id(Locators.ALLOW_DEVICE_LOCATION_WHILE_USING_APP_ID), 10);
        locationPermission.click();
	}
	
	public void clickContinueOrDoneButton() {
		// Click Continue or Done button anywhere in the application
        try {
            MobileElement continueOrDoneButton = waitForElementToBeVisible(MobileBy.id(Locators.CONTINUE_OR_DONE_BUTTON_ID), 10);
            continueOrDoneButton.click();
            System.out.println("Clicked continue button");
        } catch (NoSuchElementException e) {
            System.err.println("Continue or Done button not found: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Continue or Done button not found");
        }
    }
	
	public void dismissPopup() {
		// Dismiss pop-up if present
	    try {
	        MobileElement popup = waitForElementToBeVisible(MobileBy.id(Locators.DISMISS_POPUP_ID), 20);
	        popup.click();
	        System.out.println("Popup dismissed");
	    } catch (TimeoutException e) {
	        System.out.println("Popup not present. No action taken.");
	    }
	}
	
	public void verifyPageTitle(String expectedPageTitle) {
		//Verify title of any page in the application
		String actualpageTitle = waitForElementToBeVisible(MobileBy.id(Locators.PAGE_TITILE_ID), 10).getText();
		Assert.assertEquals(actualpageTitle,expectedPageTitle, "Page title verification failed");
		System.out.println("Page title verified" +actualpageTitle);
	}
    
	public void goBack() {
		//Go back anywhere in the application (assuming that the xpath is consistent for all pages)
        MobileElement goBack = waitForElementToBeVisible(MobileBy.xpath(Locators.BACK_BUTTON_XPATH), 10);
		goBack.click();
		System.out.println("Back button tapped.");
	}
	
    public void scrollUntilElementIsVisible(By locator, int maxScrollAttempts, String text) {
    	//Scroll until an element is visible
        int scrollAttempts = 0;
        while (scrollAttempts < maxScrollAttempts) {
            try {
                // If the element is visible, break out of the loop
                if (driver.findElement(locator).isDisplayed()) {
                    System.out.println("Element is visible.");
                    break;
                }
            } catch (Exception e) {
                // Perform a scroll gesture to scroll down
                System.out.println("Scrolling attempt: " + (scrollAttempts + 1));
                scrollDown(text);
                scrollAttempts++;
            }
        }
    }

    private void scrollDown(String text) {
        String scrollableScript = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().resourceIdMatches(\"%s\").textMatches(\"com.fivemobile.thescore:id/txt_name\").instance(0))", text);

        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(scrollableScript));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void scrollUp() {
    	//Scroll Up using touch action
    	Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = size.height / 2; // Start from the middle of the screen
        int endY = (int) (size.height * 0.2); // Adjust the end position as needed

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(startX, endY))
        .release()
        .perform();
    }

    public void scrollDown() {
    	//Scroll down using touch action
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .moveTo(PointOption.point(startX, endY))
                   .release()
                   .perform();
    }
    

}

