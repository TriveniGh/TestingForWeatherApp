package AutomationFramework;

import org.testng.annotations.Test;
import Pages.HomeP;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	WebDriverWait wait;
	HomeP home;
	
	 @BeforeTest
	  public void beforeTest() {
		 //Initialize the browser
		 System.setProperty("webdriver.ie.driver","G:\\Automation Documents\\Drivers\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 wait = new WebDriverWait(driver, 10);
			 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			 driver.get("https://openweathermap.org/");	
			 driver.manage().window().maximize();
	}
	 
	//Verification of Homepage 
@Test
  public void Test1() throws InterruptedException {
	  //Title Verification
	  String expectedTitle = "Сurrent weather and forecast - OpenWeatherMap";
	  String actualTitle = driver.getTitle();
	  System.out.println(actualTitle);
	  assertEquals(actualTitle, expectedTitle);
	  if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Test Passed!");
      } else {
          System.out.println("Test Failed");
      }
	
	  //Label Verifications
	  home= new HomeP(driver);
	  home.Label1.isDisplayed();
	  home.NavSearch.isDisplayed();
	  home.support.isDisplayed();
	  home.Jumbo_Title.isDisplayed();
	  home.CurrentLocation_title.isDisplayed();
	  home.SignIn.isDisplayed();
	  home.SignUp.isDisplayed();
	  home.MapsMenu.isDisplayed();
	  
	  //Verify that signIn Link is working
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  home.SignIn.click();
	  Thread.sleep(10000);
	  assertEquals(driver.getTitle(), "Members");
	  System.out.println("Sign-In is working");
	  driver.navigate().back();
	  Thread.sleep(5000);

	  
	  //Verify that SignUp Link is working
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  home.SignUp.click();
	  home.CreateAccount.isDisplayed();
	  System.out.println("Sign-up is working");
	  driver.navigate().back();
	  Thread.sleep(5000);
	  
	  //Verify the dropdown links
	  home.MapsMenu.click();
	  home.BeatifulPlaces.isDisplayed();
	  System.out.println("Maps-BeatifulPlaces is present");
	  driver.navigate().refresh();
	  
	    }

//Test2 -InValid City Error testcase
@Test
public void Test2() throws InterruptedException
{
	home= new HomeP(driver);
	home.SearchBox.clear();
	home.SearchBox.sendKeys("mumbaiii");
	home.SearchButton.click();
	Thread.sleep(5000);
	home.ErrorMsg.isDisplayed();
	System.out.println("Test2 -InValid City Error testcase -Passed");
}

//Test3-website successfully returns weather details for the city
@Test
public void Test3() throws InterruptedException
{
	String EnterCity = "Mumbai";
	home= new HomeP(driver);
	home.SearchBox.clear();
	home.SearchBox.sendKeys(EnterCity);
	home.SearchButton.click();
	Thread.sleep(10000);
	WebElement MessageBox = driver.findElement(By.xpath("//span[@class='badge badge-info']"));
	MessageBox.isDisplayed();
	//Verify the city name is correct or not
	//WebElement cityField = driver.findElement(By.xpath("//div[@id='forecast_list_ul']//a[starts-with(@href,'/city/')]"));
	String ActualcityName = home.cityField.getText();
	if(ActualcityName.contains(EnterCity))
	{	System.out.println("Test3-website successfully returns weather details for the city-Passed");
	}
	else
	{	System.out.println("Test3-website successfully returns weather details for the city-Failed");
	}
}

//Verify that [Current Loaction] gives correct city's Weather data
@Test
public void Test4() throws InterruptedException
{
	driver.get("https://openweathermap.org/");	
	home= new HomeP(driver);
	home.CurrentLocation.click();
	Thread.sleep(5000);
	home.CurrentLocation_title.isDisplayed();
	//Verify the current city name is correct or not
	String ActualcityName2 = home.Weather_CityName.getText();
	if(ActualcityName2.contains("Mumbai"))
	{	System.out.println("Current location is correct-Passed");
	}
	else
	{	System.out.println("Current location is incorrect");
	}
}

  @AfterTest
  public void afterTest() {
	driver.quit();
  }

}
