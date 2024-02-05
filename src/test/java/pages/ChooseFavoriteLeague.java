package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseFavoriteLeague extends Utils{
	
	public void verifyFavoriteLeaguePage() {
        MobileElement favoritePageLabel = waitForElementToBeVisible(MobileBy.id(Locators.FAVORITE_PAGE_LABEL_ID), 10);
        Assert.assertTrue(favoritePageLabel.isDisplayed());
        System.out.println("verified favorite league page title");
    }
	
	public void tapOnLeagueByName(String leagueName, int durationInSeconds) {
	    try {
	        System.out.println("Attempting to tap on league: " + leagueName);
	        
	        String xpath = String.format(Locators.LEAGUE_NAME_TEXT_VIEW_DYANMIC_XPATH, leagueName);
	        By leagueLocator = MobileBy.xpath(xpath);
	        System.out.println("Scrolling until element is visible...");
	        scrollUntilLeagueNameIsVisible(leagueLocator, durationInSeconds, leagueName);
	        MobileElement leagueElement = waitForElementToBeVisible(leagueLocator, durationInSeconds);
	        System.out.println("Element is now visible after scrolling.");
	        System.out.println("Clicking on the league element...");
	        leagueElement.click();
	        System.out.println("League element clicked successfully.");
	    } catch (Exception e) {
	        System.err.println("Error while tapping on league: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
	
