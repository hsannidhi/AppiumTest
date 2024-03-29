package pages;

import java.io.File;

//This is the base page that sets foundation for 

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	protected static AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setUp() {
		
		try {
			File appDir = new File("src/test/resources/apps");
		    File app = new File(appDir, "theScore.apk");
		    
		    DesiredCapabilities caps = new DesiredCapabilities();
		
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
	        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4_11");
	        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fivemobile.thescore");
	        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.fivemobile.thescore.ui.MainActivity");
	        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	        
	        URL url = new URL("http://127.0.0.1:4723/wd/hub");
	        
	        //driver = new AppiumDriver<MobileElement>(url, caps);
	        driver = new AndroidDriver<MobileElement>(url, caps);
       
		}catch(Exception exp){
			System.out.println("Exception occured:"+exp.getCause());
			System.out.println("Message is:"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDOwn() {
		driver.quit();		
	}



}
