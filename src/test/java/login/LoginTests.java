package login;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    private WebDriver driver;

    @Test
    public void testInvalidLogin() {
        loginPage.inputEmail("admin@email.com");
        loginPage.inputPassword("Admin@123");
        loginPage.clickLoginButton();
        System.out.println(loginPage.alertPopupMessage());
        assertTrue(loginPage.alertPopupMessage().contains("Incorrect username or password."), "Alert message error");

    }

    @Test
    public void testBlankUsernameAndPassword() {
        loginPage.clickLoginButton();
        System.out.println(loginPage.loginAndPasswordError());
        assertTrue(loginPage.loginAndPasswordError().contains("You can't leave this empty."), "Alert message error");
    }

    @Test
    public void testInvalidEmailOnly(){
        loginPage.inputEmail("test");
        assertTrue(loginPage.loginAndPasswordError().contains("The length of the Phone or Email should be 6-60 characters."), "Alert message error");
    }
}
