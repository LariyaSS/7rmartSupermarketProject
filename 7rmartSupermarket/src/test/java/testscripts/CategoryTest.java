package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="User is able to add category information")
	public void verifyUserIsAbleToAddCategoryInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputCategory =  ExcelUtility.getString(1, 0, "CategoryPage");
		boolean categoryCreatedSuccessfully;
		CategoryPage categorypage=new CategoryPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		categorypage.clickOnCategoryTile().newButtonClick().enterTheCategoryOnCategoryField(inputCategory).clickOnDiscount().chooseAnImageOnChooseFileField().enterTopMenuAndLeftMenu().moveToSaveElement().clickOnSaveButton();
		categoryCreatedSuccessfully=categorypage.verifyCategoryCreatedSuccessfullyIsDisplyed();
		assertTrue(categoryCreatedSuccessfully,"user is not able to add category information");
	}
	
	

	
}
