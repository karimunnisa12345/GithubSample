package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hooks.BaseClass;

public class LoginPage {

	 public LoginPage(){
	        PageFactory.initElements(BaseClass.getDriver(),this);
	    }
	 
	 
	 @FindBy(name = "username")
	    WebElement emaildId;
	 
	 @FindBy(name="password")
	 	WebElement password;
	 
	 @FindBy(xpath="//button[@type='submit']")
	 	WebElement loginBtn;
	 
	 @FindBy(xpath="//div[@class='alert alert-danger']")
	 	WebElement loginErrMsg;
	 
	 public void login(String e, String p) throws InterruptedException
	 {
		 emaildId.sendKeys(e);
		 password.sendKeys(p);
		 loginBtn.click();
		 Thread.sleep(3000);
	 }
	 
	 public void validateLogin()
	 {
		 	String expected="Profile not yet approved. Please contact admin";
			String actual=loginErrMsg.getText();
			System.out.println(actual);
			
			Assert.assertEquals(actual, expected,"loginErrMsg  mismatched");

	 }
}
