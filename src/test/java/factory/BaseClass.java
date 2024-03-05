package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass {
	 static WebDriver driver;
     static Properties p;

public static WebDriver initilizeBrowser() throws IOException
{
			switch(getProperties().getProperty("browser").toLowerCase()) 
			{
			case "chrome":
				 ChromeOptions opt1 = new ChromeOptions();
				 opt1.addArguments("--disable-notifications");
		        driver=new ChromeDriver(opt1);
		        System.out.println("Chrome Browser Launched.....");
		        break;
		    case "edge":
		    	 EdgeOptions opt2 = new EdgeOptions();
				  driver=new EdgeDriver(opt2);
				  System.out.println("Edge Browser Launched.....");
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
	 driver.manage().window().maximize();		  
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 return driver;
} 

public static WebDriver getDriver() {
	return driver;
}

public static Properties getProperties() throws IOException
{		 
FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
p=new Properties();
p.load(file);
return p;
}

}
