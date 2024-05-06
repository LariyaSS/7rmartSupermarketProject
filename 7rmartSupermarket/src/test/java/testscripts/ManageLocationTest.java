package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;




public class ManageLocationTest extends Base {
	@Test
	public void userIsAbleToAddALocationsInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputlocation =  ExcelUtility.getString(1, 0, "ManageLocation");
		String inputDeliverCharge=ExcelUtility.getInteger(1, 1, "ManageLocation");
		boolean alertLocationCreatedSuccessfullyIsDisplayed;
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managelocationpage.clickOnManageLocationTile().newButtonClick();
		managelocationpage.selectCountryValueFromDropDownList().selectStateValueFromDropDownList().enterTheLocationOnLocationField(inputlocation).enterTheDeliveryChargeOndeliveryChargeField(inputDeliverCharge).saveButtonClick();
		alertLocationCreatedSuccessfullyIsDisplayed=managelocationpage.verifyAlertLocationCreatedSuccessfullyIsDisplayed();
		assertTrue(alertLocationCreatedSuccessfullyIsDisplayed,"user is not able to add location information");
	}
	@Test
	public void userIsAbleToCancelLocationsInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		boolean newButtonIsDisplayed;
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managelocationpage.clickOnManageLocationTile().newButtonClick().cancelButtonClick();
		newButtonIsDisplayed=managelocationpage.verifyNewButtonIsDisplayed();
		assertTrue(newButtonIsDisplayed,"user is not able to cancel location information");
	}
	@Test
	public void userIsAbleToSearchLocationsInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		boolean countryIsDisplayed;
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managelocationpage.clickOnManageLocationTile().newButtonClick().searchMenuButtonClick().selectCountryValueFromDropDownList().searchButtonClick();
		countryIsDisplayed=managelocationpage.verifyCountryIsDisplyed();
		assertTrue(countryIsDisplayed,"Country is not displayed in the list");
	}
	
	}
	


