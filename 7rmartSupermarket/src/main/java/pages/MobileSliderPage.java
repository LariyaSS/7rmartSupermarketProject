package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage {
	
WebDriver driver;
	
	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") private WebElement mobileSliderTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']") private WebElement newButton;
	@FindBy(xpath="//select[@id='cat_id']") private WebElement categoryDropDown;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFile;
	@FindBy(xpath="//div[@class='col-sm-12']//div[contains(@class,'alert-dismissible')]") private WebElement alertMobileSliderCreatedSuccessfully;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	
	public MobileSliderPage clickOnMobileSliderTile()
	{
		mobileSliderTile.click();
		return this;
	}
	public MobileSliderPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	public MobileSliderPage selectCategoryValueFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(categoryDropDown, ExcelUtility.getString(1, 0, "MobileSliderPage"));
		return this;
	}
	public MobileSliderPage chooseFileClick(String chooseFile) throws AWTException
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility(driver);
		fileuploadutility.fileUploadUsingRobot(chooseFile);
		return this;
			
	}
	public MobileSliderPage saveButtonClick()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.explicitWaitElementToBevisible(driver, saveButton);
		saveButton.click();
		return this;
	}
	public boolean verifyAlertMobileSliderCreatedSuccessfullyIsDisplayed()
	{
	 return alertMobileSliderCreatedSuccessfully.isDisplayed();
	}
}
