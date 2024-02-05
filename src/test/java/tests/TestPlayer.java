package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.WelcomeScreenActions;

public class TestPlayer extends BaseClass{
	
	@Test
	public void testWelcomeScreen(){
		
		WelcomeScreenActions welcomePage = new WelcomeScreenActions();
		welcomePage.testWelcomeScreen();
	}

}
