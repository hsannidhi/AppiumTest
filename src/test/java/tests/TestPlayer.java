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
		ChooseFavoriteLeague chooseFavoriteLeague = new ChooseFavoriteLeague();
		Standings standings = new Standings();
		Utils utils = new Utils();
		welcomePage.testWelcomeScreen();
		chooseFavoriteLeague.verifyFavoriteLeaguePage();
		chooseFavoriteLeague.tapOnLeagueByName("NHL Hockey");
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
	}
}
