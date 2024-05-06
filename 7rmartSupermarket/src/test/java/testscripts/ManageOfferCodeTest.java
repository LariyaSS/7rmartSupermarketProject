package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	@Test
	public void verifyUserIsAbleToAddOfferInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputOffercode =  ExcelUtility.getInteger(1, 0, "ManageOfferCodePage");
		boolean alertLocationCreatedSuccessfullyIsDisplayed;
		ManageOfferCodePage manageroffercodepage=new ManageOfferCodePage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		manageroffercodepage.clickOnManageOfferCodeTile().clickOnNewMenuButton().enterTheOfferCodeOnOfferCodeField(inputOffercode).selectFirstOrderUser().moveToChooseFileElement().moveToSaveElement().clickOnSaveButton();
		alertLocationCreatedSuccessfullyIsDisplayed=manageroffercodepage.isAlertMessageDisplayed();
		assertTrue(alertLocationCreatedSuccessfullyIsDisplayed,"user is not able to add OfferCode information");
	}

}
