import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.example.VerifySubsCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubsCartTests {
    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate user subscription Success in cart page")
    private void validateVerifySubsCart() {
        new VerifySubsCartPage(driver).navigateToURL("https://automationexercise.com/")
                .ValidateHomePage().clickOnCartButton().scrollToSubscriptionText().ValidateSubscriptionText()
                .fillEmailTextField("Sam@yahoo.com").clickOnArrowButton().ValidateSuccessMessage();
    }
}