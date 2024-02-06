package pages;

import java.util.List;

import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Standings extends Utils {
	
	public void tapStandingstab(){
		MobileElement standingsTab = waitForElementToBeVisible(MobileBy.xpath(Locators.STANDINGS_TAB_ID), 10);
		standingsTab.click();
		System.out.println("clicked standings tab");
	}
	
	public String[] getTeamNames() {
	    List<MobileElement> elements = findElements(Locators.STANDINGS_TAB_STATS_NAMES_ID, 10);
	    String[] teamNames = new String[elements.size()];
	    
	    for (int i = 0; i < elements.size(); i++) {
	        teamNames[i] = elements.get(i).getText();
	    }
	    
	    return teamNames;
	}
	
	public boolean isTeamNamePresent(String teamName) {
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
		//Tap on the favorite league that was selected during on-boarding
		String favoriteLeagueLocator = String.format(Locators.FAVORITE_LEAGUE_XPATH, leagueName);
		MobileElement favoriteLeague = waitForElementToBeVisible(MobileBy.xpath(favoriteLeagueLocator), 10);
		favoriteLeague.click();
		System.out.println("clicked on favorite league");
	}
	
	public void verifyFavoritesHomeScreen() {
		MobileElement favoriteHomeScreenTab = waitForElementToBeVisible(MobileBy.id(Locators.FAVORITE_TAB_ID), 10);
		Assert.assertTrue(favoriteHomeScreenTab.isDisplayed());
		System.out.println("Favorites home screen displayed");
	}

}
