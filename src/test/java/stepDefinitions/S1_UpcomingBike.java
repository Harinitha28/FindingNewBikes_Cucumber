package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;

import PageObject.HomePage;
import PageObject.UpcomingBikePage;
import Utilities.ExcelUtils;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S1_UpcomingBike extends BaseClass {
	 HomePage hp;
	  UpcomingBikePage ubp;
	 ExcelUtils excel;
	
	
	@Given("Navigate to Zigwheels website")
	public void navigate_to_zigwheels_website() throws InterruptedException {
		
		try {
			hp.signIn();
			hp.clickNext();
			hp.clickNo();
		}
		catch (Exception e){
			
			
		}
		Thread.sleep(6000);
		/*System.out.println(BaseClass.getDriver().getTitle());
		boolean result= BaseClass.getDriver().getTitle().contains("zigWheels.com");
	Assert.assertTrue(true);*/
	   
	}

	@When("user hover newBikes and click upcomingbikes")
	public void user_hover_new_bikes_and_click_upcomingbikes() {
		hp=new HomePage(BaseClass.getDriver());
		hp.hoverNewBikes() ; //to hover new Bikes
		 hp.clickUpcomingBikes();  System.out.println("Upcoming Bikes Clicked");//to click upcoming bikes
		
	}

	

	@Then("user   select honda from manufacturer and click viewmore")
	public void user_select_honda_from_manufacturer_and_click_viewmore() {
		 ubp= new UpcomingBikePage(BaseClass.getDriver());  //creating object for upcoming Bike page 
		 ubp.selectManufacturer();         
		 ubp.selectHonda(); System.out.println("Honda selected ");
	
	}

	@Then("validate Honda bikes under 4lakh")
	public void validate_honda_bikes_under_4lakh() throws IOException {
		 ubp.BikeListViewmore();
         
	        System.out.println("======================================================================");
	   		System.out.println("New Honda Bikes Under 4.0 lakh.....");
	   		System.out.println();
	   		
	   		 excel=new ExcelUtils();
	   		excel.createSheets();
	   		int j=1;
	   		for(int i=0;i<ubp.BikeNameList().size();i++) {
	   			
	   			String bkname=ubp.BikeNameList().get(i).getText();
	   			String bkprice=ubp.BikePriceList().get(i).getText();
	   			String bklaunch=ubp.BikeLaunchDateList().get(i).getText();
	   			
	   			if(bkprice.contains("Lakh")) {
	   				String[] price=bkprice.split(" ");
	   				float value=Float.parseFloat(price[1]);
	   				if(value<=4.0) {
	   					System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
	   					excel.writeData("Honda Bikes <4L", j, 0, bkname);
	   					excel.writeData("Honda Bikes <4L", j, 1, bkprice);
	   					excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
	   					j=j+1;
	   				}
	   			}
	   			else {
	   				System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
	   				excel.writeData("Honda Bikes <4L", j, 0, bkname);
	   				excel.writeData("Honda Bikes <4L", j, 1, bkprice);
	   				excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
	   				j=j+1;
	   			}
	   			
	   		}
	   		System.out.println("======================================================================");
	   		
	   		
	   	
		 
	  
	}


}
