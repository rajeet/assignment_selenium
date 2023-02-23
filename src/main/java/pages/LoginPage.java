package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
//    Selectors
    private String emailInputField = "Please enter your Phone Number or Email";
    private String passwordInputField = "Please enter your password";
    private By loginButton = By.cssSelector("button[type='submit']");
    private By alertPopUpMessage = By.className("next-feedback-content");
    private By loginAndPasswordAlert = By.cssSelector(".error span");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getText(){
        String str = "hello world";
        return str;
    }

    public void inputEmail(String email){
        inputTextField(emailInputField, email);
    }

    public void inputPassword(String password){
        inputTextField(passwordInputField, password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String alertPopupMessage(){
        return (alertMessage(alertPopUpMessage));
    }

    public String loginAndPasswordError(){
        return (alertMessage(loginAndPasswordAlert));
    }

//    method for entering text in input field of login page.
    private void inputTextField(String placeholder, String inputText){
        driver.findElement(By.cssSelector("input[placeholder='"+placeholder + "']")).sendKeys(inputText);
    }

//    method for reading the alert message of login page.
    private String alertMessage(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }



}
