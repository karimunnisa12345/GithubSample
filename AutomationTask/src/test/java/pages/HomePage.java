package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PageUtils;

import hooks.BaseClass;

public class HomePage {

	
	 public HomePage(){
	        PageFactory.initElements(BaseClass.getDriver(),this);
	    }
	 
	 
	 @FindBy(xpath = "//div[@class='widget-content di_flex']/child::ul/li/a[text()=' Online Orientation']")
	    WebElement orientationTextField;
	 
	 @FindBy(xpath = "//*[text()='Click here to register']")
	    WebElement registrationlink;
	
	  public void orientationLink() throws InterruptedException{
	   	    	
			Thread.sleep(2000);
	    	PageUtils.scrollToElement(orientationTextField);
	    	PageUtils.waitUntilClickable(orientationTextField, 5);
	    	orientationTextField.click();
	    	Thread.sleep(2000);
	    	
	    	
	   
	  }

}
