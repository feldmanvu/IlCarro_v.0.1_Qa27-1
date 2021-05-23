import manager.DataProviders;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.user().islogged()) {
            app.user().logout();
        }

    }

    @DataProvider
    public Iterator <Object[]> validData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        return list.iterator();
    }

@DataProvider
public Iterator<Object[]> dataFile() throws IOException {
        List <Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
    String line = reader.readLine();

    while(line !=null){
     String[] splip = line.split(",");
     list.add( new Object[]{new User().withEmail(splip[0]).withPassword(splip[1])});
     line = reader.readLine();
 }
        return  list.iterator();
}

    @Test(dataProvider = "dataFile")
    public void loginTestFromFile(User user) {

        app.user().openLoginForm();
        app.user().fillLoginForm(user);

        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();
        app.user().pause(4000);
        Assert.assertTrue(app.user().islogged());
        logger.info("Test passed");

    }


    @Test (dataProvider = "validData")
    public void loginTestDataProvider(String email, String password) {

        app.user().openLoginForm();
        app.user().fillLoginForm(new User().withEmail(email).withPassword(password));

        //logger.info("Login with mail: " + "marsh@gmail.com" + "\nLogin with password:" + "Marsh1234$");
        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();
        app.user().pause(4000);
        Assert.assertTrue(app.user().islogged());
        logger.info("Test passed");

    }

    @Test(dataProvider = "dataFile", dataProviderClass = DataProviders.class)
    public void loginTestFromFileFromClass(User user) {

        app.user().openLoginForm();
        app.user().fillLoginForm(user);

        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();
        app.user().pause(4000);
        Assert.assertTrue(app.user().islogged());
        logger.info("Test passed");

    }


    @Test
    public void loginTest() {

        app.user().openLoginForm();
        app.user().fillLoginForm(new User().withEmail("marsh@gmail.com").withPassword("Marsh1234$"));
        logger.info("Login with mail: " + "marsh@gmail.com" + "\nLogin with password:" + "Marsh1234$");
        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();
        app.user().pause(4000);
        Assert.assertTrue(app.user().islogged());
        logger.info("Test passed");

    }

}
