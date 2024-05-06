package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signInButton;
	@FindBy(xpath="//p[text()='Manage Pages']//parent::div") private WebElement managePagesTile;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertPopUp;
	
	public void enterTheUsernameAndThePasswordAndclickOnSignInButton(String username,String password)
	{
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
	}
	public boolean verifyUserIsAbleToNavigateDashBord()
	{
		boolean isManagePagesTileDisplayed=managePagesTile.isDisplayed();
		return isManagePagesTileDisplayed;
	}
	public boolean verifyUserIsUnableToNavigateToDashboard()
	{
		boolean isAlertPopUpDisplayed=alertPopUp.isDisplayed();
		return isAlertPopUpDisplayed;
	}
	
	
	
}
