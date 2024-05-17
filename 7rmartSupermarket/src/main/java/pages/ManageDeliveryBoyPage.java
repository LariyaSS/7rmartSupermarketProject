package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	
WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") private WebElement manageDeliveryBoyTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']") private WebElement newMenuButton;
	@FindBy(xpath="//input[@id='name']") private WebElement nameField;
	@FindBy(xpath="//input[@id='email']") private WebElement emailField;
	@FindBy(xpath="//input[@id='phone']") private WebElement phoneNumberField;
	@FindBy(xpath="//textarea[@name='address']") private WebElement addressField;
	@FindBy(xpath="//input[@id='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertDeliveryBoyCreatedSuccessfully;
	
	public ManageDeliveryBoyPage clickOnManagedeliveryBoyTile()
	{
		manageDeliveryBoyTile.click();
		return this;
	}
	public ManageDeliveryBoyPage clickOnNewMenuButton()
	{
		newMenuButton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheNameOnNameField(String name)
	{
		nameField.sendKeys(name);
		return this;
	}
	public ManageDeliveryBoyPage enterTheEmailOnEmailField(String email)
	{
		emailField.sendKeys(email);
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheUsernameOnUsernameField(String username1)
	{
		usernameField.sendKeys(username1);
		return this;
	}
	public ManageDeliveryBoyPage enterThePasswordOnPasswordField(String password1)
	{
		passwordField.sendKeys(password1);
		return this;
	}
	public ManageDeliveryBoyPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyAlertDeliveryBoyCreatedSuccessfullyIsDisplayed()
	{
		return alertDeliveryBoyCreatedSuccessfully.isDisplayed();
	}
	 public ManageDeliveryBoyPage moveToSaveElement() {
			
			PageUtility pageutility = new PageUtility(driver);
			pageutility.moveToElement(saveButton, driver);
			return this;
		
		}
	
	
	
	
	
}
