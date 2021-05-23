package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void opencarCreationForm() {
        click(By.xpath("//a[@href='/let-car-work']"));
    }
    public void fillCarForm(Car car) {
        if (isCarCreationFormPresent()) {
            type(By.id("pickUpPlace"), car.getLocation());
            click(By.cssSelector("div.pac-item"));
            pause(2000);
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());
            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWd());
            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getCarClass());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNum());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            //type(By.cssSelector(".feature-input"), car.getFeature);

        }
    }

    public boolean isCarCreationFormPresent() {
        return isElementPresent(By.xpath("//h1[contains(., 'Let the car work')]"));
    }
    public void saveNewCar() {
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean isCarAdded() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement
                        (By.cssSelector("div.dialog-container"))));

        String text=wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        return text.contains("added");
    }

    public void searchAnothercar() {
        wd.findElement(By.xpath("//button[text()='Search cars']")).click();
    }

    public void refresh() {
        wd.navigate().refresh();
    }
}
