

import cucumber.api.java.After;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class calculadora {

    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");//Versao
        desiredCapabilities.setCapability("deviceName", "emulator-5554");//Nomedo Aparelho
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("automationName", "uiautomator2");//Xcuitest
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");//Endereço

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void calculadora() {
        MobileElement btn2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        btn2.click();
        MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSomar.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
        btn3.click();
        MobileElement btnEquals = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnEquals.click();
        MobileElement lblresult = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
        lblresult.click();
        Assert.assertEquals(lblresult.getText(),"5");
        System.out.println(lblresult);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


