package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;
import utils.PageUtils;

public class OrientationRegistration {

	 public OrientationRegistration(){
	        PageFactory.initElements(BaseClass.getDriver(),this);
	    }
	 
	 
	 @FindBy(xpath = "//div[@class='col-md-4']")
	    WebElement orientationOptions;
	
	    public void orientationOption() throws InterruptedException {
	    	PageUtils.waitUntilClickable(orientationOptions, 20);
	    	orientationOptions.click();
	    	Thread.sleep(2000);
	    	
	    }
	    
	@FindBy(xpath="//button[@type='button']")
		WebElement registerBtn;
	
	public void registerButton() throws InterruptedException{
		PageUtils.waitUntilClickable(registerBtn, 10);
		registerBtn.click();
		Thread.sleep(3000);
	}
	
	
}

