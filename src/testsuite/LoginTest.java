package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*2. Create the package ‘testsuite’ and create the following classes inside the ‘testsuite’ package.
 1. LoginTest 2. ForgotPasswordTest
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
    /*3. Write down the following test into ‘LoginTest’ class
    1. userSholdLoginSuccessfullyWithValidCredentials
    * Enter “Admin” username * Enter “admin123 password
    * Click on ‘LOGIN’ button
    * Verify the ‘Welcome’ text is display - can't see Welcome so use Employee Information
    Employee Information
     */
    public void userShouldLoginSuccessfullyWithValidCredentials (){
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginbutton.click();
        WebElement mes = driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Employee Information";
        Assert.assertEquals(expectedmes,actualmes);
    }



    @After
    public void teardown () {
        closeBrowser();
    }
}
