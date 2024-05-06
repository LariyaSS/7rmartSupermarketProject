package testscripts;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyUserIsAbleToLoginWithValidUsernameAndValidPassword()
	{
		String inputUsername=ExcelUtility.getString(1, 0, "Loginpage");
	    String inputPassword=ExcelUtility.getString(1, 1, "Loginpage");
	    boolean isManagePagesTileDisplayed;
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername,inputPassword);
	    isManagePagesTileDisplayed=loginpage.verifyUserIsAbleToNavigateDashBord();
	    assertTrue(isManagePagesTileDisplayed,"User is not able to login with valid username and valid password");
	    
	}
		
    @Test
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndValidPassword()
	{
    	String inputUsername=ExcelUtility.getString(2, 0, "Loginpage");
	    String inputPassword=ExcelUtility.getString(2, 1, "Loginpage");
	    boolean isAlertPopUpDisplayed;
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
	    isAlertPopUpDisplayed=loginpage.verifyUserIsUnableToNavigateToDashboard();
	    assertTrue(isAlertPopUpDisplayed,"User is able to login even if Invalid username and valid password");
	}
    @Test
    public void verifyUserIsUnableToLoginWithValidUsernameAndInvalidPassword()
	{
    	String inputUsername=ExcelUtility.getString(3, 0, "Loginpage");
	    String inputPassword=ExcelUtility.getString(3, 1, "Loginpage");
	    boolean isAlertPopUpDisplayed;
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
	    isAlertPopUpDisplayed=loginpage.verifyUserIsUnableToNavigateToDashboard();
	    assertTrue(isAlertPopUpDisplayed,"User is able to login even if Invalid username and valid password");
	}
	@Test
    public void verifyUserIsUnableToLoginWithInvalidUsernameAndInvalidPassword()
   	{
       	String inputUsername=ExcelUtility.getString(4, 0, "Loginpage");
   	    String inputPassword=ExcelUtility.getString(4, 1, "Loginpage");
   	    boolean isAlertPopUpDisplayed;
   	    LoginPage loginpage=new LoginPage(driver);
   	    loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
   	    isAlertPopUpDisplayed=loginpage.verifyUserIsUnableToNavigateToDashboard();
   	    assertTrue(isAlertPopUpDisplayed,"User is able to login even if Invalid username and valid password");
   	}
   	
    
}
