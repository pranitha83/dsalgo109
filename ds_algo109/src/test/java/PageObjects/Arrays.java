package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
import stepdefinitions.BasePage;

public class Arrays extends BasePage {
	WebDriver driver =driversetup.getDriver();
	@FindBy(xpath = "//body//div[2]//a[text()='Get Started']")  WebElement arrayGetStarted;

	@FindBy(xpath = "//a[text()='Arrays in Python']") WebElement arraysInPython;

	@FindBy(xpath = "//a[text()='Try here>>>']") WebElement tryHere;

	@FindBy(xpath ="//form[@id='answer_form']/div/div/div/textarea") WebElement textbox;

	@FindBy(xpath ="//button[text()='Run']") WebElement runbutton;

	@FindBy(xpath = "//pre[@id='output']") WebElement output;
	@FindBy(xpath = "//form[@id='answer_form']/div//div[6]//span//span") WebElement txtclr;
	@FindBy(linkText = "Arrays Using List") WebElement Arraysusinglist;
	@FindBy(linkText = "Basic Operations in Lists")WebElement BOInList;
	@FindBy(linkText = "Applications of Array") WebElement AppOfArray;
	
	
	
	
	public Arrays (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ArrayGetStarted() {

		arrayGetStarted.click();
	}

	public void ArraysInPython() {
		arraysInPython.click();
	}

	public void TryHere() {
		tryHere.click();
	}

	public void Txtarea(String pythoncode,String output) {

		textbox.sendKeys(pythoncode);
		System.out.println(pythoncode);
		//Boolean isRequired = false;
		//return isRequired;

	}
	public void textclear() {
		/*while (txtclr.getText().equals("")) {
	        txtclr.sendKeys(Keys.BACK_SPACE);
	       }
//txtclr.getText().equals("");*/
		driver.navigate().back();
	}

	public void Runbutton() {
		runbutton.click();
	}
	public String outPut() {
		
		

		
	//boolean isRequired=false;
	//String alerttxt=alert.getText();
		//System.out.println("Alert : "+alerttxt);
		//return isRequired;
	

	return output.getText(); 
		
	}
	public String gethomepageTitle() {
		return "NumpyNinja";

	}
	public void arraysList() {
		Arraysusinglist.click();
	}
	public void BasicOpInList() {
		BOInList.click();
	}
	public void ApplOfArray() {
		AppOfArray.click();
	}
	
}
