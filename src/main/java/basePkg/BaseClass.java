package basePkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	
	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					new File("C:\\Users\\User\\eclipse-workspace\\OctoberBatchTDDPOM\\src\\main\\"
							+ "java\\configPkg\\config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void initialization() {
		String browser = prop.getProperty("browserName");
		
		// cross browser testing
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default: 
				System.out.println("Invalid brower selected.");
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("workingUrl"));
	}
	
	public void tearDown() {
		driver.quit();
	}

}
