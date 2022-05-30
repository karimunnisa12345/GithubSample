package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.OrientationPage;
import pages.OrientationRegistration;
import pages.RegistrationPage;
import utils.PropertyUtils;

public class TestSandbox {
	
	HomePage homepage;
	LoginPage loginpage;
	OrientationPage opage;
	OrientationRegistration oregistration;
	RegistrationPage rpage;	
	
	BaseClass baseClass=new BaseClass();
	
	@BeforeTest
	public void open()
	{
		//baseClass.setupBrowser();
		BaseClass.getDriver().get(PropertyUtils.getProperty("test.website.url"));
		BaseClass.getDriver().manage().window().maximize();
        BaseClass.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
	}
	
	@Test
	public void test() throws InterruptedException
	{
		homepage=new HomePage();
		homepage.orientationLink();
		
		opage=new OrientationPage();
		opage.registration();
		
		oregistration=new OrientationRegistration();
		oregistration.orientationOption();
		oregistration.registerButton();
		
		rpage=new RegistrationPage();
		rpage.registration("arshiya","syed","arshu257@yopmail.com","8795488695","arshu257","arshu257");
		rpage.validateWelcomeMsg();
		rpage.RegistrationButton();
		rpage.validateRegistrationMsg();
		
		loginpage=new LoginPage();
		loginpage.login("arshu786@yopmail.com","arshu786");
		loginpage.validateLogin();
		
	}
	
	
}
