package factory;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger; 

	public static WebDriver driverLaunch() throws IOException {

		DesiredCapabilities cap = new DesiredCapabilities();

		if(getproperties().getProperty("execution_env").equalsIgnoreCase("remote")) {

			if(getproperties().getProperty("os").equalsIgnoreCase("windows"))
				cap.setPlatform(Platform.WIN11);
			else if(getproperties().getProperty("os").equalsIgnoreCase("mac"))
				cap.setPlatform(Platform.MAC);

			if(getproperties().getProperty("browser").equalsIgnoreCase("chrome"))
				cap.setBrowserName("chrome");
			else if(getproperties().getProperty("browser").equalsIgnoreCase("edge"))
				cap.setBrowserName("edge");

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}

		if(getproperties().getProperty("execution_env").equalsIgnoreCase("local")) {

			driver = HelperClass.browserLauch(getproperties().getProperty("browser"));
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	
	 
	public static WebDriver getDriver() {
		return driver;
		
	}

	public static Properties getproperties() throws IOException {
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileReader file = new FileReader(path);
		Properties p = new Properties();
		p.load(file);
		return p;
	}
	
	public static BufferedImage screenShot() throws AWTException, IOException {

		Robot r = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSize);
		BufferedImage source = r.createScreenCapture(rectangle);
		String path = System.getProperty("user.dir")+"\\screenshots\\errorScreenshot.png"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		ImageIO.write(source, "png", destination);

		return source;

	}

	public static Logger getlogger() {
		logger = LogManager.getLogger();
		return logger;
	}
	
	public static String alpa() {
		String alpa = RandomStringUtils.randomAlphabetic(4);
		return alpa;
	}

	public static String num() {
		String num = RandomStringUtils.randomNumeric(10);
		return num;

	}

	public static String name() {
		String alpa = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(4);

		String pass = alpa+"@"+num;
		return pass;
	}

}
