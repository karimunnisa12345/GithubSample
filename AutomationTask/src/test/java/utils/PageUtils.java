package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.BaseClass;

public class PageUtils {

	 public static WebDriverWait webDriverWait(int waitTime){
	        return new WebDriverWait(BaseClass.getDriver(),waitTime);
	 }
	 public static void waitUntilClickable(WebElement element, int waitTime){
	        webDriverWait(waitTime).until(ExpectedConditions.elementToBeClickable(element));
	    }

	public static void scrollToElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) BaseClass.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}

