package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Configuration.*;

public class RadioButtonTests {



    @Test
    @Parameters({ "baseUrl" })
    public void RBT(String baseUrl){
        System.out.println("გაეშვა RBT");
        open(baseUrl);
        ChromeOptions options = new ChromeOptions();

        Configuration.browserCapabilities = options;
        screenshots=true;
        reportsFolder="src/main/resources/CheckboxFailedTests";


    }

    @Test(dependsOnMethods = {"RBT"})
    public void Checkbox(){
        $("#checkboxes input:nth-child(3)").click();


        SoftAssert soft = new SoftAssert();
        SelenideElement noRadio = $("input[type='checkbox']");
        soft.assertTrue(noRadio.isEnabled());
        soft.assertAll();



    }

    @Test(dependsOnMethods = {"Checkbox"})
    public void CheckboxCheck(){
        $("#checkboxes input:nth-child(3)").click();
        $("#checkboxes input:nth-child(1)").click();


        SoftAssert soft = new SoftAssert();
        soft.assertFalse($("#checkboxes input:nth-child(1)").getAttribute("checked").isEmpty());
        soft.assertFalse($("#checkboxes input:nth-child(3)").getAttribute("checked").isEmpty());
        soft.assertAll();



    }


    @Test(dependsOnMethods = {"CheckboxCheck"})
    public void RadioButtons(){
        open("https://demoqa.com/radio-button");

        $("input.custom-control-input").doubleClick();


        SoftAssert soft = new SoftAssert();
        soft.assertTrue($("input#noRadio").isEnabled());
        soft.assertAll();
    }

}
