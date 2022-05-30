package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;
import utils.PageUtils;

public class OrientationPage {

	 public OrientationPage(){
	        PageFactory.initElements(BaseClass.getDriver(),this);
	    }
	 
	 
	 @FindBy(xpath = "//*[text()='Click here to register']")
	    WebElement registrationlink;
	
	    public void registration() throws InterruptedException{
	    	
	    	
	    	String parent=BaseClass.getDriver().getWindowHandle();
	    	
	    	
	    	Set<String> windows=BaseClass.getDriver().getWindowHandles();
			Iterator<String> it=windows.iterator();
			while(it.hasNext())
			{
				String childwindow=it.next();
				if(!childwindow.contains(parent))
				{
					BaseClass.getDriver().switchTo().window(childwindow);
					Thread.sleep(3000);
					PageUtils.waitUntilClickable(registrationlink, 5);
					registrationlink.click();
					Thread.sleep(2000);
				}
	    	
	    	
			}
	    }

}
