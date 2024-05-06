package utilities;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	public void contextClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void elementTODragAndDrop(WebElement elementDragged,WebElement elementPlaced) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementDragged,elementPlaced).perform();
	}
	
	public void selectSingleDropdownValue(WebElement dropDown,String dropDownvalue)
	{
		Select selectsingledropdown=new Select(dropDown);
		selectsingledropdown.selectByValue(dropDownvalue);
	}
    
	public void selectDropdownValue(WebElement dropDown,String dropDownvalue)
	{
		Select selectsingledropdowntext=new Select(dropDown);
		selectsingledropdowntext.selectByVisibleText(dropDownvalue);
	}
	public void selectDropdownByUsingIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void javaScriptExecutorClick(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);
	}
	public void javaScriptExecutorScrollInToView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void javaScriptExecutorScrollForWard(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void javaScriptExecutorScrollBackWard(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	public String toGetAttributeValue(WebElement element,String attribute)
	{
		String attributeValue=element.getAttribute(attribute);
		return attributeValue;
	}
	public void navigateToBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void alertUsingAccept() 
	{
		driver.switchTo().alert().accept();
	}
	public void alertUsingDismiss() 
	{
		driver.switchTo().alert().dismiss();
	}
	public String alertUsingGetText()
	{
		return driver.switchTo().alert().getText();
	}
	public void alertUsingSendKeys(String target)
	{
		driver.switchTo().alert().sendKeys(target);
	}
	
}
