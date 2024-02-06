package pages;

import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Leagues extends Utils {
	
	public void goToLeaguesPage() {
		System.out.println("Attempting to click Allow Location button...");
        MobileElement allowLocationButton = waitForElementToBeVisible(MobileBy.id(Locators.LOCATION_ACCESS_ALLOW_BUTTON_ID), 10);
        allowLocationButton.click();
        System.out.println("Allow Location button clicked");
        MobileElement locationPermission = waitForElementToBeVisible(MobileBy.id(Locators.ALLOW_DEVICE_LOCATION_WHILE_USING_APP_ID), 10);
        locationPermission.click();
        waitForElementToBeVisible(MobileBy.id(Locators.CONTINUE_OR_DONE_BUTTON_ID), 10).click();
        System.out.println("Continue button clicked 2.");
        waitForElementToBeVisible(MobileBy.id(Locators.CONTINUE_OR_DONE_BUTTON_ID), 10).click();
        System.out.println("Done button clicked");
        waitForElementToBeVisible(MobileBy.id(Locators.DISMISS_POPUP_ID), 10).click();
        System.out.println("Popup dismissed");
        waitForElementToBeVisible(MobileBy.id(Locators.LEAGUE_TAB_ID), 10).click();
        System.out.println("Leader tab clicked");
        waitForElementToBeVisible(MobileBy.id(Locators.DISMISS_QTIP_ID), 10).click();
        System.out.println("Edit Qtip dismissed");
	}

	public void verifyLeaguesPageTitle(String expectedPageTitle) {
		String actualpageTitle = waitForElementToBeVisible(MobileBy.id(Locators.PAGE_TITILE_ID), 10).getText();
		Assert.assertEquals(actualpageTitle,expectedPageTitle, "Page title verification failed");
		System.out.println("Leagues page title verified");
	}
	
}
