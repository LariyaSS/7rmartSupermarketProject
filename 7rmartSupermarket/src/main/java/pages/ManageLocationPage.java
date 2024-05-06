package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']") private WebElement manageLocationTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']") private WebElement newButton;
	@FindBy(xpath="//select[@id='country_id']") private WebElement countryDropDown;
	@FindBy(xpath="//select[@id='st_id']") private WebElement stateDropDown;
	@FindBy(xpath="//input[@id='location']") private WebElement locationTextField;
	@FindBy(xpath="//input[@id='delivery']") private WebElement deliveryChargeTexField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[@class='col-sm-12']//child::div") private WebElement alertLocationCreatedSuccessfully;
	@FindBy(xpath="//div[@class='card-footer']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']") private WebElement cancelButton;
		
	@FindBy(xpath="//a[@href='javascript:void(0)']") private WebElement searchMenuButton;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchButton;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//thead//tr//th[2]") private WebElement searchCountry;
	
	public ManageLocationPage clickOnManageLocationTile()
	{
		manageLocationTile.click();
		return this;
	}
	public ManageLocationPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	public ManageLocationPage selectCountryValueFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(countryDropDown,ExcelUtility.getString(1, 2, "ManageLocation"));
		return this;
	}
	public ManageLocationPage selectStateValueFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(stateDropDown, ExcelUtility.getString(1, 3, "ManageLocation"));
		return this;
	
	}
	
	public ManageLocationPage enterTheLocationOnLocationField(String locationname)
	{
		locationTextField.sendKeys(locationname);
		return this;
	}
	public ManageLocationPage enterTheDeliveryChargeOndeliveryChargeField(String deliverycharge)
	{
		deliveryChargeTexField.sendKeys(deliverycharge);
		return this;
	}
	public ManageLocationPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyAlertLocationCreatedSuccessfullyIsDisplayed()
	{
		return alertLocationCreatedSuccessfully.isDisplayed();
	}
	public ManageLocationPage cancelButtonClick()
	{
		cancelButton.click();
		return this;
	}
	public boolean verifyNewButtonIsDisplayed()
	{
		return newButton.isDisplayed();
	}
	public ManageLocationPage searchMenuButtonClick()
	{
		searchMenuButton.click();
		return this;
	}
	public ManageLocationPage searchButtonClick()
	{
		searchButton.click();
		return this;
	}
	public boolean verifyCountryIsDisplyed() 
	{
		return searchCountry.isDisplayed();
	}
	
}
