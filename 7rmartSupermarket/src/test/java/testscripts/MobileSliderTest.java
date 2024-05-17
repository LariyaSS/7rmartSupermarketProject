package testscripts;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.Constants;
import utilities.ExcelUtility;


public class MobileSliderTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class,priority=1,description="verify user is able to add a mobile slider information")
	
	public void verifyUserIsAbleAddMobileSliderInformations() throws AWTException
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String uploadImage=Constants.MOBILESLIDERIMAGEPATH;
		boolean alertMobileSliderCreatedSuccessfully;
		MobileSliderPage mobilesliderpage=new MobileSliderPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		mobilesliderpage.clickOnMobileSliderTile().newButtonClick().selectCategoryValueFromDropDownList().chooseFileClick(uploadImage).saveButtonClick();
		alertMobileSliderCreatedSuccessfully=mobilesliderpage.verifyAlertMobileSliderCreatedSuccessfullyIsDisplayed();
		assertTrue(alertMobileSliderCreatedSuccessfully,"user is not able to mobile slider informations");
		
	}

}
