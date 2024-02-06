package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class ChooseFavoriteLeague extends Utils{
	
	public void verifyFavoriteLeaguePage() {
		
		//This is the on-boarding screen - 'Choose your favorite leagues'
        MobileElement favoritePageLabel = waitForElementToBeVisible(MobileBy.id(Locators.FAVORITE_PAGE_LABEL_ID), 20);
        Assert.assertTrue(favoritePageLabel.isDisplayed());
        System.out.println("verified favorite league page title");
    }
	
	public void tapOnLeagueByName(String leagueName, int durationInSeconds) {
		//This is a parameter driven method to which a league name can be passed.
		
	    try {
	        System.out.println("Attempting to tap on league: " + leagueName);
	        String xpath = String.format(Locators.LEAGUE_NAME_TEXT_VIEW_DYANMIC_XPATH, leagueName);
	        By leagueLocator = MobileBy.xpath(xpath);
	        
	        System.out.println("Scrolling until element is visible...");
	        scrollUntilElementIsVisible(leagueLocator, durationInSeconds, leagueName);
	        
	        MobileElement leagueElement = waitForElementToBeVisible(leagueLocator, durationInSeconds);
	        System.out.println("Element is now visible after scrolling.");
	        
	        leagueElement.click();
	        System.out.println("League element clicked successfully.");
	        
	    } catch (NoSuchElementException e) {
	    	
	        System.err.println("League not found. Can be implemented further." + e.getMessage());
	        e.printStackTrace();
	        // If league element is not found, implement the solution (e.g. click continue button)
	    }
	}
	
}
	
