package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    CarHelper car;
    SearchHelper search;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
        user = new UserHelper(wd);
        car = new CarHelper(wd);
        search= new SearchHelper(wd);

    }

    public void stop() {

        wd.quit();
    }

    public CarHelper car() {
        return car;
    }

    public UserHelper user() {
        return user;
    }

    public SearchHelper search() {
        return search;
    }
}
