package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.ChooseFavoriteLeague;
import pages.Standings;
import pages.Utils;
import pages.WelcomeScreenActions;

public class TestPlayer extends BaseClass{
	
	WelcomeScreenActions welcomePage = new WelcomeScreenActions();
	ChooseFavoriteLeague chooseFavoriteLeague = new ChooseFavoriteLeague();
	Standings standings = new Standings();
	Utils utils = new Utils();
	
	
	
	@Parameters({"tapFavoriteLeague","favoriteLeagueInStandingsTab","pageTitle","findTeamName"})
	@Test
	public void testTeamNameInStandingsTab(String tapFavoriteLeagueValue, String TapFavoriteLeagueValue, String pageTitleValue, String findTeamNameValue) throws InterruptedException{
		//Test Welcome screen
		welcomePage.testWelcomeScreen();
		//Choose a Favorite League during on-boaring
		chooseFavoriteLeague.verifyFavoriteLeaguePage();
		chooseFavoriteLeague.tapOnLeagueByName(tapFavoriteLeagueValue);
		//Navigate to Favorites home page
		utils.clickContinueOrDoneButton();
		utils.allowLocationPermission();
		utils.clickContinueOrDoneButton();
		utils.clickContinueOrDoneButton();
		utils.dismissPopup();
		//Verify if the given team name is present in a list of team names in Standings tab
		standings.tapFavoriteLeague(TapFavoriteLeagueValue);
		standings.tapStandingstab();
		utils.verifyPageTitle(pageTitleValue);
		standings.isTeamNamePresent(findTeamNameValue);
		utils.goBack();
		standings.verifyFavoritesHomeScreen();
	}
}
