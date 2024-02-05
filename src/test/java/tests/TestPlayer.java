package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.ChooseFavoriteLeague;
import pages.WelcomeScreenActions;

public class TestPlayer extends BaseClass{
	
	@Test
	public void testWelcomeScreen(){
		
		WelcomeScreenActions welcomePage = new WelcomeScreenActions();
		ChooseFavoriteLeague favoriteLeague = new ChooseFavoriteLeague();
		welcomePage.testWelcomeScreen();
		favoriteLeague.verifyFavoriteLeaguePage();
		favoriteLeague.tapOnLeagueByName("Wrestling", 10);
	}
}
