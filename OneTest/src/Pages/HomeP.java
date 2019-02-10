package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeP {
	WebDriver driver;
	
	public HomeP(WebDriver driver) {
	      PageFactory.initElements(driver, this);
	  }
	 
	
		  @FindBy(css = "img[src='/themes/openweathermap/assets/vendor/owm/img/logo_OpenWeatherMap_orange.svg']")
		public WebElement Label1;

		  @FindBy(xpath = "//span[contains(text(),'Support Center')]")
		  public WebElement support;
		  
		  @FindBy(xpath = "//a[@class='pull-right'][@id='nav-search']")
		  public WebElement NavSearch;
		  
		  @FindBy(xpath = "//h2[contains(text(),'We Deliver 2 Billion Forecasts Per Day')]")
		  public WebElement Jumbo_Title;
		  
		  @FindBy(xpath = "//a[text()=' Sign In']")
		  public WebElement SignIn;
		  
		  @FindBy(xpath = "//a[text()=' Sign Up']")
		  public WebElement SignUp;
		  
		  @FindBy(xpath = "//a[text()='Maps ']")
		  public WebElement MapsMenu;
		  
		  @FindBy(xpath = "//a[contains(text(),'Beautiful places')]")
		  public WebElement BeatifulPlaces;
		  
		  @FindBy(xpath = "//h3[contains(text(),'Create New Account')]")
		  public WebElement CreateAccount;
		  @FindBy(xpath = "//input[@class='form-control border-color col-sm-12']")
		  public WebElement SearchBox;
		  
		  @FindBy(xpath = "//button[contains(text(),' Search')]")
		  public WebElement SearchButton;

		  @FindBy(xpath = "//div[contains(text(),'Not found')]")
		  public WebElement ErrorMsg;
		  
		  @FindBy(xpath = "//div[@id='forecast_list_ul']//span[@class='badge badge-info']")
		  public WebElement MessageBox;
		  
		  @FindBy(xpath = "//div[@id='forecast_list_ul']//a[starts-with(@href,'/city/')]")
		  public WebElement cityField;
		  
		  @FindBy(xpath = "//button[contains(text(),'  Current location')]")
		  public WebElement CurrentLocation;
		  
		  
		  @FindBy(xpath = "//h2[contains(text(),'Current weather and forecasts in your city')]")
		  public WebElement CurrentLocation_title;
		  
		  @FindBy(id = "#tab-main")
		  public WebElement MainTab;
		  
		  @FindBy(xpath = "//h2[@class='weather-widget__city-name']")
		  public WebElement Weather_CityName;
		  
		 
		 
		}
		 
