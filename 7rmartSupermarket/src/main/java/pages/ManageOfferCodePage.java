package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageOfferCodePage {
	
WebDriver driver;
	
	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") private WebElement manageOfferCodeTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']") private WebElement newMenuButton;
	@FindBy(xpath="//input[@id='offer_code']") private WebElement offerCodeField;
	@FindBy(xpath="//input[@value='yes']") private WebElement radioFirstOrderValueYes;
	@FindBy(xpath="//input[@value='no']") private WebElement radioFirstOrderValueNo;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFile;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertOfferOrderSavedSuccessfully;
	
	public ManageOfferCodePage clickOnManageOfferCodeTile()
	{
		manageOfferCodeTile.click();
		return this;
	}
	public ManageOfferCodePage clickOnNewMenuButton()
	{
		newMenuButton.click();
		return this;
	}
	public ManageOfferCodePage enterTheOfferCodeOnOfferCodeField(String offercode)
	{
		offerCodeField.sendKeys(offercode);
		return this;
	}
	public ManageOfferCodePage selectFirstOrderUser()
	{
		 radioFirstOrderValueYes.click();
		 return this;
	}
	public ManageOfferCodePage selectAnImageOnChooseFile()
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility(driver);
		fileuploadutility.fileUploadUsingSendKeys(driver, chooseFile, Constants.MANAGEOFFERCODEIMAGEPATH);
		return this;
	}
	public ManageOfferCodePage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isAlertMessageDisplayed()
	{
		return alertOfferOrderSavedSuccessfully.isDisplayed();
	}
	public ManageOfferCodePage moveToChooseFileElement() {
		
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(chooseFile, driver);
		return this;
	
	}
    public ManageOfferCodePage moveToSaveElement() {
		
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(saveButton, driver);
		return this;
	
	}
	
	
	
	

}
