import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedBasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedAirlinesBase {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedBasePage unitedBasePage;

    @BeforeMethod
    public void pageSetup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));
    }
    @AfterMethod
    public void tearDown(){
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
