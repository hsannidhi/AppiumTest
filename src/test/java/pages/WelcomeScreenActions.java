package pages;

//This page verifies the first screen on installing the app.

import org.testng.Assert;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class WelcomeScreenActions extends Utils {
	
	public void testWelcomeScreen() {
		
		MobileElement welcomeIcon = waitForElementToBeVisible(MobileBy.id("com.fivemobile.thescore:id/icon_welcome"), 10);
        Assert.assertTrue(welcomeIcon.isDisplayed());

        MobileElement welcomeText = findElement(MobileBy.id("com.fivemobile.thescore:id/txt_welcome"), 10);
        Assert.assertTrue(welcomeText.isDisplayed());
        
        MobileElement getStartedButton = findElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"), 10);
        Assert.assertTrue(getStartedButton.isDisplayed());
        
        getStartedButton.click();
        
        System.out.println("Get Started button tapped");
    }
}
