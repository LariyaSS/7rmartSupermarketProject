package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageOrdersPage {
	
WebDriver driver;
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']") private WebElement manageOrderTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchMenuButton;
	@FindBy(xpath="//input[@id='od']") private WebElement orderIdField;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchButton;
	@FindBy(xpath="//table/tbody/tr[1]//td[6]//a[1]") private WebElement changeStatus;
	@FindBy(xpath = "//button[@class='btn btn-info'][1]") private WebElement updateButton;
	@FindBy(xpath = "//select[@id='status']") private WebElement deliveryStatusDropDown;
	@FindBy(xpath = "//table/tbody/tr/td[6]/span[1]") private WebElement newStatus;
	
    public ManageOrdersPage clickOnManageLocationTile()
	{
		manageOrderTile.click();
		return this;
	}
	public ManageOrdersPage searchMenuButtonClick()
	{
		searchMenuButton.click();
		return this;
	}
	public ManageOrdersPage enterOrderIdOnOrderIdField(String Orderid) {
		orderIdField.sendKeys(Orderid);
		return this;
	}
   public ManageOrdersPage searchButtonClick()
   {
	   searchButton.click();
	   return this;
   }
   public ManageOrdersPage selectDeliveryStatusValueFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(deliveryStatusDropDown, ExcelUtility.getString(1, 1, "ManagerOrderPage"));
		return this;
	
	}
   public ManageOrdersPage changeStatusButtonClick()
   {
	   changeStatus.click();
	   selectDeliveryStatusValueFromDropDownList();
	   return this;
   }
   public ManageOrdersPage clickOnUpdateButton()
   {
	   updateButton.click();
	   return this;
   }
   public boolean verifyCurrentDeliveryStatus() {
	  return newStatus.isDisplayed();
	}
    public ManageOrdersPage moveToElement() {
	
	PageUtility pageutility = new PageUtility(driver);
	pageutility.moveToElement(changeStatus, driver);
	return this;
	
}
   
}
