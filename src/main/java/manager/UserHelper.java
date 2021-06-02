package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickLoginButton() {
        //click(By.xpath("//button[text()='Yalla!']"));
        click(By.xpath("//button[@type='submit']"));
    }

    public void successLogin() {
        click(By.xpath("//button[text()='Ok']"));
    }
    public boolean islogged(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }
    public void loggin(User user){
        openLoginForm();
        fillLoginForm(user);
        clickLoginButton();
        pause(2000);
        successLogin();
    }
}
