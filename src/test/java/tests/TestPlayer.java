package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.ChooseFavoriteLeague;
import pages.Standings;
import pages.Utils;
import pages.WelcomeScreenActions;

public class TestPlayer extends BaseClass{
	
	@Test
	public void testWelcomeScreen() throws InterruptedException{
		
		WelcomeScreenActions welcomePage = new WelcomeScreenActions();
		ChooseFavoriteLeague favoriteLeague = new ChooseFavoriteLeague();
		Standings standings = new Standings();
		Utils utils = new Utils();
		welcomePage.testWelcomeScreen();
		favoriteLeague.verifyFavoriteLeaguePage();
		favoriteLeague.tapOnLeagueByName("NHL Hockey", 10);
		utils.clickContinueOrDoneButton();
		utils.allowLocationPermission();
		utils.clickContinueOrDoneButton();
		utils.clickContinueOrDoneButton();
		utils.dismissPopup();
		standings.tapFavoriteLeague("NHL");
		standings.tapStandingstab();
		utils.verifyPageTitle("NHL");
		System.out.println("Title of the page verified");
		standings.isTeamNamePresent("BOS Bruins");
		utils.goBack();
		standings.verifyFavoritesHomeScreen();
		System.out.println("done");
	}
}
