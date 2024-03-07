import TestUtils.AndroidBaseTest;
import com.cosmotronica.pageObjects.android.CartPage;
import com.cosmotronica.pageObjects.android.ProductCatalogue;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {
    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void FillForm(HashMap<String, String> input) throws InterruptedException {

        //extent.createTest();
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));

        formPage.setCountrySelection(input.get("country"));

        ProductCatalogue productCatalogue =
        formPage.submitForm();

        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);

        CartPage cartPage =
        productCatalogue.goToCartPage();

        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum, displayFormattedSum);

        cartPage.acceptTermsConditions();

        cartPage.submitOrder();



//
//        Set<String> contexts = driver.getContextHandles();
//        for (String contextName : contexts){
//            System.out.println(contextName);
//        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//
//        driver.findElement(By.name("q")).sendKeys("test case");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.context("NATIVE_APP");
        //Hybrid app - google page ->



    }

//    @BeforeMethod
//    public void preSetup(){
//        //waitForElementToAppear(setGender);
//        formPage.setActivity();
//    }
//
//    @DataProvider
//    public Object[][] getData() throws IOException {
//        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") +
//                "/src/test/java/testData/eCommerce.json");
//        return new Object[][]{ {data.get(0)}, {data.get(1)} };
//    }

//    @BeforeMethod
//    public void preSetup() throws InterruptedException {
////        //screen to home page
//////        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//////        driver.startActivity(activity);
//Thread.sleep(3000);
//((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
//      "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
//
//        //formPage.setActivity();
//        Thread.sleep(3000);
//    }

    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src/test/java/testData/eCommerce.json");
        //	return new Object[][] { {"rahul shetty","female","Argentina"},{"shetty MR","male","Argentina"}  };


        return new Object[][] { {data.get(0)} };
    }
}

