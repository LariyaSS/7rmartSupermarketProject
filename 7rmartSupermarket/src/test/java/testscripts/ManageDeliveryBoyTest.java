package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="User is able to add delivery boy information")
	public void userIsAbleToAddDeliveryBoyInformations()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputName =  ExcelUtility.getString(1, 0, "ManageDeliveryBoyPage");
		String inputEmail=ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		String inputUsername1 =  ExcelUtility.getString(1, 2, "ManageDeliveryBoyPage");
		String inputPassword1=ExcelUtility.getString(1,3, "ManageDeliveryBoyPage");
		boolean alertDeliveryBoyCreatedSuccessfully;
		ManageDeliveryBoyPage managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managedeliveryboypage.clickOnManagedeliveryBoyTile().clickOnNewMenuButton();
		managedeliveryboypage.enterTheNameOnNameField(inputName).enterTheEmailOnEmailField(inputEmail).enterTheUsernameOnUsernameField(inputUsername1).enterThePasswordOnPasswordField(inputPassword1).moveToSaveElement().clickOnSaveButton();
		alertDeliveryBoyCreatedSuccessfully=managedeliveryboypage.verifyAlertDeliveryBoyCreatedSuccessfullyIsDisplayed();
		assertTrue(alertDeliveryBoyCreatedSuccessfully,"user is not able to add delivery boy information");
	}

}
