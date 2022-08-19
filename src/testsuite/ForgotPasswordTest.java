package testsuite;
/*4. Write down the following test into ‘ForgotPasswordTest’ class
 1. userShouldNavigateToForgotPasswordPageSuccessfully
  * click on the ‘Forgot your password’ link
  * Verify the text ‘Forgot Your Password?’
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToForgotPasswordPageSuccessfully (){
        WebElement forgotYourPassword = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotYourPassword.click();
        WebElement mes = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Reset Password";
        Assert.assertEquals(expectedmes,actualmes);
    }

    @After
    public void teardown (){

        closeBrowser();
    }
}
