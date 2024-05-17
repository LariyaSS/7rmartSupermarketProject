package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUsersPage {
	
WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement adminUserTile;
	@FindBy(xpath="//a[text()=' New']") private WebElement newMenuButton;
	@FindBy(xpath="//input[@id='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath="//select[@id='user_type']") private WebElement usertypeDropDownField;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertUserCreatedSuccessfully;
	public AdminUsersPage clickOnAdminUserTile()
	{
		adminUserTile.click();
		return this;
	}
	public AdminUsersPage clickOnNewButton()
	{
		newMenuButton.click();
		return this;
	}
	public AdminUsersPage enterTheUsernameOnUsernameField(String username)
	{
		usernameField.sendKeys(username);
		return this;
	}
	public AdminUsersPage enterThePasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public AdminUsersPage selectUserTypeFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(usertypeDropDownField,ExcelUtility.getString(1, 2, "AdminUsersPage"));
		return this;
	}
	public AdminUsersPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyAlertUserCreatedSuccessfullyIsDisplayed()
	{
		return alertUserCreatedSuccessfully.isDisplayed();
	}
}
