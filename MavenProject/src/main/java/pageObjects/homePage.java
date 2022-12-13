package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homePage {

WebDriver driver;
	
	public homePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToHomePage() {
		driver.get("https://portfolio.rediff.com/portfolio-login");
	}
}
