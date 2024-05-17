package testscripts;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="User is able to login with valid username and valid password")
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
		
    @Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="user is unable to login with invalid username and valid password")
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
    @Test(groups= {"smoke"},retryAnalyzer=retry.Retry.class,description="User is unable to login with valid username and invalid password")
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
	@Test(dataProvider="LoginProvider",retryAnalyzer=retry.Retry.class,description="User is unable to login with invalid username and invalid password")
    public void verifyUserIsUnableToLoginWithInvalidUsernameAndInvalidPassword(String inputUsername,String inputPassword)
   	{
        boolean isAlertPopUpDisplayed;
   	    LoginPage loginpage=new LoginPage(driver);
   	    loginpage.enterTheUsernameAndThePasswordAndclickOnSignInButton(inputUsername, inputPassword);
   	    isAlertPopUpDisplayed=loginpage.verifyUserIsUnableToNavigateToDashboard();
   	    assertTrue(isAlertPopUpDisplayed,"User is able to login even if Invalid username and valid password");
   	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(4, 0, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage") },

		};
	}
}
