package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.FileUploadUtility;


public class ManageSliderPage {
	
WebDriver driver;
	
	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") private WebElement manageSliderTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") private WebElement newMenuButton;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFile;
	@FindBy(xpath="//input[@id='link']") private WebElement linkField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertSliderCreatedSuccessfully;

	public ManageSliderPage clickOnManageSliderTile()
	{
		manageSliderTile.click();
		return this;
	}
	public ManageSliderPage clickOnNewMenuButton()
	{
		newMenuButton.click();
		return this;
	}
	
	public ManageSliderPage chooseAnImageOnChooseFile()
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility(driver);
		fileuploadutility.fileUploadUsingSendKeys(driver, chooseFile, Constants.MANAGESLIDERIMAGEPATH);
	    return this;
	}
	public ManageSliderPage enterTheLinkOnLinkField(String linknname)
	{
		linkField.sendKeys(linknname);
		return this;
		
	}
	public ManageSliderPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
		
	}
	public boolean verifySliderCreatedSuccessfullyIsDisplyed()
	{
		return alertSliderCreatedSuccessfully.isDisplayed();
	}
	
	
	
	
	
	
}
