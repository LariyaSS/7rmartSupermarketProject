package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	@Test
	public void verifyUserIsAbleToAddSliderInformation()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputlink =  ExcelUtility.getString(1, 0, "ManageSliderPage");
		boolean alertSliderCreatedSuccessfullyIsDisplayed;
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managesliderpage.clickOnManageSliderTile().clickOnNewMenuButton().chooseAnImageOnChooseFile().enterTheLinkOnLinkField(inputlink).chooseAnImageOnChooseFile().clickOnSaveButton();
		alertSliderCreatedSuccessfullyIsDisplayed=managesliderpage.verifySliderCreatedSuccessfullyIsDisplyed();
		assertTrue(alertSliderCreatedSuccessfullyIsDisplayed,"user is not able to add slider information");
	}

}
