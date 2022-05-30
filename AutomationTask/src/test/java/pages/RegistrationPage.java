package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hooks.BaseClass;
import utils.PageUtils;

public class RegistrationPage {

	 public RegistrationPage(){
	        PageFactory.initElements(BaseClass.getDriver(),this);
	    }
	 
	 
	 @FindBy(xpath = "//input[@name='fname']")
	    WebElement firstName;
	 
	 @FindBy(xpath="//input[@name='lname']")
	 	WebElement lastName;
	 
	 @FindBy(xpath="//input[@name='email']")
	 	WebElement email;
	 
	 @FindBy(xpath="//input[@name='phno']")
	 	WebElement phone;
	 
	 @FindBy(xpath="//input[@name='password']")
	 	WebElement password;
	 
	 @FindBy(xpath="//input[@name='cpassword']")
	 	WebElement confirmPassword;
	 
	@FindBy(xpath="//div[@class='row mt-6 mb-6']")
		WebElement checkbox;
	
	@FindBy(xpath="//button[@type='submit']")
		WebElement button;
	
	@FindBy(xpath="//h4[text()='Welcome']")
		WebElement welcomemsg;
	
	@FindBy(xpath="//form[@class='reset-password-form']/child::div[1]")      //div[@class='row mt-6 mb-6']/div")
		WebElement checkboxs;
	
	@FindBy(xpath="//button[@type='submit']")
		WebElement registerbtn;
	
	@FindBy(xpath="//div[@class='modal-header']/button")
		WebElement crossbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
		WebElement registervalidatemsg;
	
	public void registration(String fn, String ln, String e, String ph, String pwd, String cpwd) throws InterruptedException {
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(e);
		phone.sendKeys(ph);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cpwd);
		Thread.sleep(3000);
		checkbox.click();
		Thread.sleep(3000);
		button.click();
		Thread.sleep(3000);
	}
	
	public void validateWelcomeMsg()
	{
		String expected="Welcome";
		String actual=welcomemsg.getText();
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected,"welcome msg mismatched");
			
	}
	
	public void RegistrationButton() throws InterruptedException
	{
		Thread.sleep(3000);
		PageUtils.scrollToElement(checkboxs);
		PageUtils.waitUntilClickable(checkboxs, 20);
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass.getDriver();
        executor.executeScript("arguments[0].click();", checkboxs);
		
		//Actions actions = new Actions(BaseClass.getDriver());
		//actions.moveToElement(checkboxs).click().build().perform();
		
		//checkboxs.click();
		Thread.sleep(5000);
		registerbtn.click();
		Thread.sleep(5000);
		crossbtn.click();
		Thread.sleep(5000);
	}
	
	public void validateRegistrationMsg()
	{
		String expected="Registered successfully";
		String actual=registervalidatemsg.getText();
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected,"registervalidation msg mismatched");
	}
}
