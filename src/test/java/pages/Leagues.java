package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Leagues extends Utils {
	
	public void goToLeaguesPage() {
        waitForElementToBeVisible(MobileBy.id(Locators.LEAGUE_TAB_ID), 10).click();
        System.out.println("Leader tab clicked");
        waitForElementToBeVisible(MobileBy.id(Locators.DISMISS_QTIP_ID), 10).click();
        System.out.println("Edit Qtip dismissed");
	}
	
	public void tapLeaderstab() throws RuntimeException {
        MobileElement leadersTab = waitForElementToBeVisible(MobileBy.xpath(Locators.LEADERS_TAB_XPATH), 20);

        // Click the Leaders tab if it's visible
        if (leadersTab != null) {
            leadersTab.click();
            System.out.println("Leaders tab clicked successfully.");
        } else {
            System.err.println("Leaders tab not visible. Throwing an exception.");
            throw new RuntimeException("Leaders tab not visible.");
        }
    }
}
