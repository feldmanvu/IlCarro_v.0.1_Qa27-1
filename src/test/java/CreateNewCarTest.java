import models.Car;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {
    @BeforeMethod
    public void precondition() {

    }

    @Test
    public void createNewCar() {

        Car car=new Car().withLocation("Tel-Aviv")
                .withMake("Subaru")
                .withModel("Forester")
                .withYear("2017")
                .withEngine("2000")
                .withFuel(" Petrol ")
                .withGear("AT")
                .withWd(" RWD ")
                .withDoors("5")
                .withSeats("5")
                .withCarClass("Luxury")
                .withFuelConsumption("10")
                .withCarRegNum("8511432")
                .withPrice("350")
                .withDistanceIncluded("500")
                ;

        app.car().opencarCreationForm();
        app.car().fillCarForm(car);
        app.car().attachFoto("String link");
    }

    @AfterMethod
    public void postConditions() {

    }
}
