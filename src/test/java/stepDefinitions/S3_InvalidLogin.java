package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import PageObject.HomePage;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S3_InvalidLogin {
HomePage hp;
	@When("user clicks login and gives invalid input")
	public void user_clicks_login_and_gives_invalid_input() {
		hp=new HomePage(BaseClass.getDriver());
		hp.clickLogin();
		hp.clickGoogle();
		
		 Set<String> allWindowHandles = BaseClass.getDriver().getWindowHandles(); // to handle multiple windows
	      String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
	      BaseClass.getDriver().switchTo().window(windowId[1]);
	      hp.email(); 
	    
	}
	
	

	@Then("user gets error msg")
	public void user_gets_error_msg() {
		 JavascriptExecutor js = (JavascriptExecutor)BaseClass.getDriver();
	       js.executeScript("arguments[0].click();", hp.next);// to click next using javascript excecutor 
	      try {
	    	  Thread.sleep(10000);
	    	  
	      }
	      catch(Exception e) {
	    	  
	      }
	  
	       System.out.println("Error Message: "+ hp.errormsg.getText());
	   
	}


}
