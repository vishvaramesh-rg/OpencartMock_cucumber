package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	
	static WebDriver driver;
	
	public static WebDriver browserLauch(String browser) {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();break;

		default:
			System.out.println("no match");
		}
		
		return driver;
		
	}

}
