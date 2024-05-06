package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageOrdersTest extends Base {
	@Test
	public void verifyUserIsAbleToSearchAnOrderedItemAndUpdateStatus()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
		String inputOrderId=ExcelUtility.getInteger(1, 0, "ManagerOrderPage");
		boolean isCurrentDeliveryStatusDisplayed;
		ManageOrdersPage managerorderspage=new ManageOrdersPage(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
		managerorderspage.clickOnManageLocationTile().searchMenuButtonClick().enterOrderIdOnOrderIdField(inputOrderId).searchButtonClick().moveToElement().changeStatusButtonClick().clickOnUpdateButton();
		PageUtility pageutility=new PageUtility(driver);
		pageutility.navigateToBack(driver);
		isCurrentDeliveryStatusDisplayed=managerorderspage.verifyCurrentDeliveryStatus();
		assertTrue(isCurrentDeliveryStatusDisplayed,"user is not able to search and update an ordered item");
		
		
	}
	

}
