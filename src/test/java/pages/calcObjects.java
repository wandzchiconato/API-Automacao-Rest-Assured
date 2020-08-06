package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class calcObjects {
    private MobileDriver<MobileElement> driver;

    public calcObjects(){

    }
    public calcObjects(MobileDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        }


    MobileElement btn0 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");
    MobileElement btn1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");
    MobileElement btn2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
    MobileElement btn3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
    MobileElement btn4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_4");
    MobileElement btn5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_5");
    MobileElement btn6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_6");
    MobileElement btn7 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_7");
    MobileElement btn8 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_8");
    MobileElement btn9 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_9");


    MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
    MobileElement btnSubtrair = (MobileElement) driver.findElementByAccessibilityId("minus");
    MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
    MobileElement btnDividir = (MobileElement) driver.findElementByAccessibilityId("divide");


    MobileElement btnEquals = (MobileElement) driver.findElementByAccessibilityId("equals");
    MobileElement btnLimpar = (MobileElement) driver.findElementByAccessibilityId("delete");
    MobileElement btnDecimal = (MobileElement) driver.findElementByAccessibilityId("point");
    MobileElement btnMenu = (MobileElement) driver.findElementByAccessibilityId("More Options");


    MobileElement lblresult = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

}
