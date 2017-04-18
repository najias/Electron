package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {
	
	// (ReadProperties-parents === Driver- child/inhetance)

	public static WebDriver driver;

	public void setDriver() {
		if (getProperty("browser").equalsIgnoreCase("Firefox")) {
			initFirefox();
		} else {
			initFirefox();
		}
		setDriverProperties();

	}

	private void initFirefox() {
		driver = new FirefoxDriver();
	}

	private void setDriverProperties() {
		driver.manage().window().maximize();

	}

}
