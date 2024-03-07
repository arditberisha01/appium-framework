package com.cosmotronica.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtils{

    IOSDriver driver;

    public IOSActions(IOSDriver driver){
        //super(driver);
        this.driver = driver;
    }

    public void longPressAction(WebElement ele, int duration){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration", duration);

        driver.executeScript("mobile:touchAndHold", params);
    }

//    public void scrollToEndAction(){
//        boolean canScrollMore;
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", 100, "top", 100, "width", 200, "height", 200,
//                    "direction", "down",
//                    "percent", 3.0
//            ));
//        }while (canScrollMore);
//    }

    public void swipeAction(WebElement ele, String direction){
        Map<String, Object> paramss = new HashMap<String, Object>();
        paramss.put("direction", direction);
        //paramss.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:swipe", paramss);
    }

//    public void dragDropAction(WebElement ele, int x, int y){
//        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) ele).getId(),
//                "endX", x,
//                "endY", y
//        ));
//
//    }
//
//    public Double getFormattedAmount(String amount){
//        Double price = Double.parseDouble(amount.substring(1));
//        return price;
//    }

    public void scrollToWebElement(WebElement ele){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll", params);
    }

}
