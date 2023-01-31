package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
   private static WebDriver driver;

   public static WebDriver getDriver(){
       if(driver == null){
           String browser = ConfigReader.getProperty("browser");

           switch (browser.toLowerCase()){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               default:
                   throw new IllegalStateException(browser + " does not match any case.");
           }
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitwait")), TimeUnit.SECONDS);
       }
       return driver;
   }
   public static void closeDriver(){
       if(driver != null){
           driver.manage().deleteAllCookies();
           driver.close();
           driver = null;
       }
   }
}
