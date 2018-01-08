package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author SurajS
 *
 */
public class ConfigDataProvider {
	static Properties pro;
	static WebDriver driver;
	
	//constructor and load properties file
	public ConfigDataProvider(){
		
		File src=new File("./config/path.properties");		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			System.out.println(e.getMessage());
		}
	}
	
	public static String getprop(String locatorkey)
	{
		String pdata=pro.getProperty(locatorkey);
		return pdata;
	}
	public static String getURL()
	{
		String pdata=pro.getProperty("Testurl");
		return pdata;
	}
	public static WebDriver getBrowser(String browserName)
	{
		
			if(browserName.equalsIgnoreCase("internetexplorer"))
			{	
					//System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEpath());			
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(capabilities);			
					System.out.println(" IE driver set");
			}
			else if(browserName.equalsIgnoreCase("chrome"))
			{
				//System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromepath());
				driver = new ChromeDriver();			
	
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			driver.get("http://facebook.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			return driver;
		}
		public static void closeBrowser(WebDriver driver)
		{
			driver.close();
		}
		public static void quitBrowser(WebDriver driver)
		{
			driver.quit();
		}
}
