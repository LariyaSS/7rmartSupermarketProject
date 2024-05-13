package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class CategoryPage {
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement categoryTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") private WebElement newMenuButton;
	@FindBy(xpath="//input[@id='category']") private WebElement categoryField;
	@FindBy(xpath="//ul[@class='ms-list']//child::li[@id='134-selectable']") private WebElement discountField;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileField;
	@FindBy(xpath="//input[@name='top_menu'][1]") private WebElement radioTopMenuYes;
	@FindBy(xpath="//input[@name='show_home'][1]") private WebElement radioLeftMenuYes;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement categoryCreatedSuccessfully;
	
		
	public CategoryPage clickOnCategoryTile()
	{
		categoryTile.click();
		return this;
	}
	public CategoryPage newButtonClick()
	{
		newMenuButton.click();
		return this;
	}
	public CategoryPage enterTheCategoryOnCategoryField(String categoryname)
	{
		categoryField.sendKeys(categoryname);
		return this;
	}
	public CategoryPage clickOnDiscount()
	{
		discountField.click();
		return this;
	}
	public CategoryPage chooseAnImageOnChooseFileField()
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility(driver);
		fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileField, Constants.CATEGORYIMAGEPATH);
	    return this;
		
	}
	public CategoryPage enterTopMenuAndLeftMenu()
	{
		radioTopMenuYes.isSelected();
		radioLeftMenuYes.isSelected();
		return this;
	}
	public CategoryPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public CategoryPage moveToSaveElement() {
		
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(saveButton, driver);
		return this;
	
	}
	public boolean verifyCategoryCreatedSuccessfullyIsDisplyed()
	{
		return categoryCreatedSuccessfully.isDisplayed();
	}
	
}
