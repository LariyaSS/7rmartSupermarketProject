package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test
	public void userIsAbleToAddAdminUsersInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputUsername1 =ExcelUtility.getString(1, 0, "AdminUsersPage");
		String inputpassword1=ExcelUtility.getString(1, 1, "AdminUsersPage");
		boolean alertUserCreatedSuccessfully;
		AdminUsersPage adminuserpage=new AdminUsersPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		adminuserpage.clickOnAdminUserTile().clickOnNewButton().enterTheUsernameOnUsernameField(inputUsername1).enterThePasswordOnPasswordField(inputpassword1).selectUserTypeFromDropDownList().saveButtonClick();
		alertUserCreatedSuccessfully=adminuserpage.verifyAlertUserCreatedSuccessfullyIsDisplayed();
		assertTrue(alertUserCreatedSuccessfully,"user is not able to add admin user informations");
	}

}
