package pages;

//This page contains methods to interact with Standings tab - including entering into and exiting out of Standings

import java.util.List;

import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Standings extends Utils {
	
	public void tapStandingstab(){
		//Tap Standings tab
		MobileElement standingsTab = waitForElementToBeVisible(MobileBy.xpath(Locators.STANDINGS_TAB_ID), 10);
		standingsTab.click();
		System.out.println("Standings tab tapped");
	}
	
	public String[] getTeamNames() {
		//Get team names in Standings tab
	    List<MobileElement> elements = findElements(Locators.STANDINGS_TAB_STATS_NAMES_ID, 20);
	    String[] teamNames = new String[elements.size()];
	    
	    for (int i = 0; i < elements.size(); i++) {
	        teamNames[i] = elements.get(i).getText();
	    }
	    
	    return teamNames;
	}
	
	public boolean isTeamNamePresent(String teamName) {
		//Verify if the parameter team name is present
	    String[] teamNames = getTeamNames();
	    
	    for (String name : teamNames) {
	        if (name.equals(teamName)) {
	            System.out.println("Team name '" + teamName + "' is present.");
	            return true;
	        }
	    }
	    
	    System.out.println("Team name '" + teamName + "' is not present.");
	    return false;
	}
	
	public void tapFavoriteLeague(String leagueName) {
		//Tap on the favorite league that was selected during on-boarding (on the top list of favorites bar)
		String favoriteLeagueLocator = String.format(Locators.FAVORITE_LEAGUE_XPATH, leagueName);
		MobileElement favoriteLeague = waitForElementToBeVisible(MobileBy.xpath(favoriteLeagueLocator), 10);
		favoriteLeague.click();
		System.out.println("Favorite league icon tapped");
	}
	
	public void verifyFavoritesHomeScreen() {
		//Verify if the favorite home screen is displayed
		MobileElement favoriteHomeScreenTab = waitForElementToBeVisible(MobileBy.id(Locators.FAVORITE_TAB_ID), 10);
		Assert.assertTrue(favoriteHomeScreenTab.isDisplayed());
		System.out.println("Favorites home screen displayed");
	}

}
