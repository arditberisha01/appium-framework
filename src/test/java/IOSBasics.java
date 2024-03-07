import TestUtils.IOSBaseTest;
import com.cosmotronica.pageObjects.ios.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void IOSBasicsTest(){

        //locators in iOS: xpath, classname, ios, iosClasschain, iospredicatestring, accesibility id

        AlertViews alertViews = homePage.selectAlertViews();
        alertViews.setTextEntry("test");

        String actualMessage = alertViews.getConfirmMessage();
        Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");



        //driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
//        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
//        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("hello world");
//        driver.findElement(AppiumBy.accessibilityId("OK")).click();
//
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
//        String taski = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'A message'")).getText();
//        System.out.println(taski);
//        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

        //longpress, scroll, swipe, slides and dropdowns

    }
}
