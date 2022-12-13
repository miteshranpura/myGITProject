package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='useremail']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='userpass']")
	WebElement passWord;
	
	public void LoginAction (String uname, String pwd) {
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
	}
}
	