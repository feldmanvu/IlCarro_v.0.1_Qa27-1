import manager.DataProviders;
import models.Car;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.user().islogged()) {
            app.user().loggin();
        }

    }

    @Test(dataProvider = "dataCarFile",dataProviderClass = DataProviders.class)
    public void createNewCarDataProvider(Car car) {
    app.car().pause(2000);

        logger.info("Create new card with Registered number: " + car.getCarRegNum());

        app.car().opencarCreationForm();

        app.car().fillCarForm(car);

        app.car().attachFoto("C://QA27//IlCarro_v.0.1_Qa27//bmw.jpeg");
        app.car().pause(2000);
        app.car().saveNewCar();
       app.car().pause(2000);
        Assert.assertTrue(app.car().isCarAdded());
        logger.info("Test passed and car with number--> " +car.getCarRegNum() +" was added");
    }

    @Test
    public void createNewCar() {
        app.car().pause(2000);
        Car car = new Car().withLocation("Tel-Aviv")
                .withMake("Subaru")
                .withModel("Forester")
                .withYear("2017")
                .withEngine("2000")
                .withFuel("Petrol")
                .withGear("AT")
                .withWd("RWD")
                .withDoors("5")
                .withSeats("5")
                .withCarClass("Luxury")
                .withFuelConsumption("10")
                .withCarRegNum("11111439")
                .withPrice("350")
                .withDistanceIncluded("500");
        logger.info("Create new card with Registered number: " + car.getCarRegNum());

        app.car().opencarCreationForm();

        app.car().fillCarForm(car);

        app.car().attachFoto("C://QA27//IlCarro_v.0.1_Qa27//bmw.jpeg");
        app.car().pause(2000);
        app.car().saveNewCar();
        app.car().pause(2000);
        Assert.assertTrue(app.car().isCarAdded());
        logger.info("Test passed and car with number--> " + car.getCarRegNum() + " was added");
        app.car().refresh();
    }
    @AfterMethod
    public void postConditions() {

  app.car().searchAnothercar();
    }
}
