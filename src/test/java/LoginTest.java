import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        app.user().openLoginForm();
        app.user().fillLoginForm();



    }
}
