package org.example;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class VerifySubsCartPage {
    private SHAFT.GUI.WebDriver driver;

    public VerifySubsCartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private By HomePage = By.xpath("//a[@style=\"color: orange;\"]");
    private By CartButton = By.xpath("//a[@href=\"/view_cart\"]//i[@class=\"fa fa-shopping-cart\"]");
    private By SubscriptionText = By.xpath("//div[@class=\"single-widget\"]//h2");
    private By EmailTextField = By.xpath("//input[@id=\"susbscribe_email\"]");
    private By ArrowButton = By.xpath("//button[@id=\"subscribe\"]");
    private By SuccessMessage = By.xpath("//div[@class=\"alert-success alert\"]");

    public VerifySubsCartPage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public VerifySubsCartPage scrollToSubscriptionText() {
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(driver.getDriver().findElement(SubscriptionText)).perform();
        return this;
    }

    public VerifySubsCartPage clickOnCartButton() {
        driver.element().click(CartButton );
        return this;

    }

    public VerifySubsCartPage fillEmailTextField(String email) {
        driver.element().type(EmailTextField, email);
        return this;
    }

    public VerifySubsCartPage clickOnArrowButton() {
        driver.element().click(ArrowButton );
        return this;

    }

    @Step("Validate that the user is on Home Page")
    public VerifySubsCartPage ValidateHomePage() {
        driver.element().verifyThat(HomePage).text().contains("Home");
        return this;
    }

    @Step("Validate that subscription text is appear")
    public VerifySubsCartPage ValidateSubscriptionText() {
        driver.element().verifyThat(SubscriptionText).text().contains("SUBSCRIPTION");
        return this;
    }

    @Step("Validate that success message is appear")
    public VerifySubsCartPage ValidateSuccessMessage() {
        driver.element().verifyThat(SuccessMessage).text().contains("You have been successfully subscribed!");
        return this;
    }



}
