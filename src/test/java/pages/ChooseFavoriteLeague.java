package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class ChooseFavoriteLeague extends Utils{
	
	public void verifyFavoriteLeaguePage() {
        MobileElement favoritePageLabel = waitForElementToBeVisible(MobileBy.id(Locators.FAVORITE_PAGE_LABEL_ID), 10);
        Assert.assertTrue(favoritePageLabel.isDisplayed());
        System.out.println("verified favorite league page title");
    }
	
	public void tapOnLeagueByName(String leagueName, String resourceId, int durationInSeconds) {
	    try {
	        System.out.println("Attempting to tap on league: " + leagueName);
	        String xpath = String.format(Locators.LEAGUE_NAME_TEXT_VIEW_DYANMIC_XPATH, resourceId, leagueName);
	        System.out.println("xpath is:" + xpath);
	        By leagueLocator = MobileBy.xpath(xpath);
	        System.out.println("Scrolling until element is visible...");
	        scrollUntilElementIsVisible(leagueLocator, durationInSeconds, resourceId, leagueName);
	        MobileElement leagueElement = waitForElementToBeVisible(leagueLocator, durationInSeconds);
	        System.out.println("Element is now visible after scrolling.");
	        System.out.println("Clicking on the league element...");
	        leagueElement.click();
	        System.out.println("League element clicked successfully.");
	    } catch (NoSuchElementException e) {
	        System.err.println("Error while tapping on league: " + e.getMessage());
	        e.printStackTrace();
	        // If league element is not found, handle the situation (e.g., click continue button)
	    }
	}

	
	public void clickContinueOrDoneButton() {
        try {
            System.out.println("Attempting to click Continue or Done button...");
            MobileElement continueOrDoneButton = waitForElementToBeVisible(MobileBy.id(Locators.CONTINUE_OR_DONE_BUTTON_ID), 10);
            continueOrDoneButton.click();
            System.out.println("Clicked continue button");
        } catch (NoSuchElementException e) {
            System.err.println("Continue or Done button not found: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Continue or Done button not found");
        }
    }
	
}
	
