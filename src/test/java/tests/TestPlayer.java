package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.ChooseFavoriteLeague;
import pages.Leagues;
import pages.WelcomeScreenActions;

public class TestPlayer extends BaseClass{
	
	@Test
	public void testWelcomeScreen(){
		
		WelcomeScreenActions welcomePage = new WelcomeScreenActions();
		ChooseFavoriteLeague favoriteLeague = new ChooseFavoriteLeague();
		Leagues leagues = new Leagues();
		welcomePage.testWelcomeScreen();
		favoriteLeague.verifyFavoriteLeaguePage();
		favoriteLeague.tapOnLeagueByName("NHL Hockey","com.fivemobile.thescore:id/txt_name", 10);
		favoriteLeague.clickContinueOrDoneButton();
		leagues.goToLeaguesPage();
		leagues.verifyLeaguesPageTitle("Leagues");
		favoriteLeague.tapOnLeagueByName("NHL","com.fivemobile.thescore:id/league_name_text", 10);
	}

}
