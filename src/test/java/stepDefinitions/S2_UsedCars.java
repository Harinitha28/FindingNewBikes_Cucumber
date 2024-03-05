package stepDefinitions;

import java.io.IOException;

import PageObject.PopularModel;
import PageObject.UpcomingBikePage;
import Utilities.ExcelUtils;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S2_UsedCars  extends BaseClass{
	PopularModel pm;
	ExcelUtils excel;
	  UpcomingBikePage ubp;
	 

	
	@When("User hover usedcars and click chennai")
	public void user_hover_usedcars_and_click_chennai() {
		ubp= new UpcomingBikePage(BaseClass.getDriver());
		ubp.hoverUsedcar();
    	pm= new PopularModel(BaseClass.getDriver());
	    pm.selectChennai() ;
	    
	}

	@Then("print all popular models in usedcar")
	public void print_all_popular_models_in_usedcar() throws IOException {
		 System.out.println("popular models in used car...");
			pm.scroll();
		   int j=1;
		   excel=new ExcelUtils();
		    for( int i=0;i< pm.popularModelList().size();i++)
			 {
		    	String bklaunch=pm.popularModelList().get(i).getText();
				 System.out.println(bklaunch);
			 excel.writeData("Popular Model Cars", j, 0, bklaunch);
				j=j+1;
				 }
	    
	}

	@Then("navigate to home page")
	public void navigate_to_home_page() throws InterruptedException {
		pm.selectLogo();
		 Thread.sleep(5000);
	    
	}


}
