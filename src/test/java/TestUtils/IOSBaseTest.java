package TestUtils;

import com.cosmotronica.pageObjects.ios.HomePage;
import com.cosmotronica.utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    //1. tell Appium what driver were using
    //2. start appium server and add the ip and port inside new URL()
    //3. capabilities(which app, which OS, ect)

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {


        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));


        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro");
        //options.setApp("/Users/arditberisha/IdeaProjects/Appium_Android/appium_test/src/test/java/resources/ApiDemos-debug.apk");

        options.setApp("/Users/arditberisha/Library/Developer/Xcode/DerivedData/UIKitCatalog-fplefiuxlgsgchcqsieuufeizeym/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        //options.setApp("/Users/arditberisha/IdeaProjects/Appium_Android/appium_test/src/test/java/resources/TestApp 3.app");
        options.setPlatformVersion("17.0");
        //Appium- Webdriver Agent -> iOS Apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        //---real-device iphone capabilities---
//        d.setCapability("xcodeOrgId","xxxxxxxx");
//        d.setCapability("xcodeSigningId","iPhone Developer");
//        d.setCapability("udid","xxxxxxxx");
//        d.setCapability("updateWDABundleId","xxxxxxx");



        //Initialize driver

        driver = new IOSDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }




    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}

///Users/arditberisha/Downloads/Xcode-beta.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk
//export DEVELOPER_DIR=/Users/arditberisha/Downloads/Xcode-beta.app/Contents/Developer
 //       export IOS_SDK_ROOT=/Users/arditberisha/Downloads/Xcode-beta.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk
