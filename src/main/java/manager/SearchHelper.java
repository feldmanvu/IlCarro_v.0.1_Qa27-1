package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public boolean listOfCarsAppeared(){
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormByType(String city, String dateFrom, String dataTo) {
        fillInputCity(city);
        typeInputPeriod(dateFrom,dataTo);
    }

    private void typeInputPeriod(String dateFrom, String dataTo) {
        type(By.id("dates"),dateFrom+" - "+dataTo);
        wd.findElement(By.id("dates")).sendKeys(Keys.ENTER);

    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        pause(500);
        click(By.cssSelector("div.pac-item"));

    }

    public void clickYallaBtn() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormBySelectDate(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMounth(dateFrom,dateTo);
    }
//    "5/15/2021"   "5/25/2021"
    private void selectPeriodCurrentMounth(String dateFrom, String dateTo) {
        wd.findElement(By.id("dates")).click();
        String[]from =dateFrom.split("/");
        String[]to = dateTo.split("/");
        //String locator ="//div[text()='"+from[1]+"']";
        String locator =String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));
        String locator2 =String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));

    }

    public void fillSearchFormByTypeNeg(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodNeg(from,to);
    }

    private void typeInputPeriodNeg(String from, String to) {
        type(By.id("dates"),from + " - " +to);
        //wd.findElement(By.id("dates")).sendKeys(Keys.ENTER);
        //click(By.id("dates"));
    }

    public boolean buttonYallaInactive() {
       WebElement button = wd.findElement(By.xpath("//button[@type='submit']"));
       return !button.isEnabled();
    }

    public boolean isDataInPath() {
       // String text= wd.findElement(By.xpath("//div[@class='ng-star-inserted']")).getText();
        //return isElementPresent(By.xpath("//div[text()=\" You can't pick date before today \"]"));
        return isElementPresent(By.xpath("//div[@class='ng-star-inserted']"));
    }

    public void fillserchfom(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodCheckData(from,to);
    }
// "6/1/2021","6/12/2021"
    private void typeInputPeriodCheckData(String from, String to) {

        String[] dataFrom =from.split("/");
        String []dataTo = to.split("/");
        click(By.id("dates"));
        int diffStart=0;

        if(LocalDate.now().getMonthValue()!=Integer.parseInt(dataFrom[0])){
            diffStart=Integer.parseInt(dataFrom[0])-LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator =String.format("//div[text()=' %s ']",dataFrom[1]);
        click(By.xpath(locator));






        String locator2 =String.format("//div[text()=' %s ']",dataTo[1]);
        click(By.xpath(locator2));
    }
}
