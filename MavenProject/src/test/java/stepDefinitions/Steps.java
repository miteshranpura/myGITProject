package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Login;
import pageObjects.homePage;

public class Steps {

	WebDriver driver;
	
	public Steps() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\miteshmr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);System.setProperty("webdriver.chrome.driver","C:\\Users\\miteshmr\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
	@Given("user is on loginPage")
	public void user_is_on_homepage() {
		homePage home = new homePage(driver);
		home.navigateToHomePage();
	}
	
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		Login login = new Login(driver);
		login.LoginAction("miteshranpura@yahoo.co.in", "7659119");
	}
	
	@Then("success message is displayed")
	public void success_message_is_displayed() {
	    System.out.println("Success");
	    
	    TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Downloads\\testScrnshot.png");
		
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    driver.quit();
	}
}
/* Code w/o POM
	public static WebDriver driver;	
	public static WebElement username, pwd;
	
	@Given("user is on homepage")
	public void user_is_on_homepage() throws Throwable{
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\miteshmr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://portfolio.rediff.com/portfolio-login");
	}

	@When("user navigates to login page")
	public void user_navigates_to_login_page() throws Throwable{
	    username = driver.findElement(By.xpath("//input[@id='useremail']"));
		pwd = driver.findElement(By.xpath("//input[@id='userpass']"));
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws Throwable{
	    username.sendKeys("miteshranpura@yahoo.co.in");
		pwd.sendKeys("7659119");
	}

	@Then("success message is displayed")
	public void success_message_is_displayed() {
	    System.out.println("Success");
	    driver.quit();
	}
*/
