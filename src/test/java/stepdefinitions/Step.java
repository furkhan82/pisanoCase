package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PisanoPage;
import utils.ConfigReader;
import utils.Driver;

import com.github.javafaker.Faker;

import java.time.Duration;
import java.util.Locale;

public class Step {
    private WebDriver driver;
    private WebDriverWait wait;

    private Faker faker = new Faker();
    private String name;
    private String country;
    private String email;
    private String phonenumber;
    PisanoPage pisanoPage = new PisanoPage();
    public Step() {
        // WebDriver'ı al
        driver = Driver.getDriver();
        Duration timeout = Duration.ofSeconds(2);
        // WebDriverWait oluştur
        wait = new WebDriverWait(driver, timeout);
    }

    @Given("Navigate to given Url")
    public void navigate_to_given_url() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }

    @Then("Access to the given Widget")
    public void access_to_the_given_widget() {
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pisanoPage.iframeLogin));

        pisanoPage.iframeLogin.click();
    }

    @Then("Open the Send Feedback Screen")
    public void open_the_send_feedback_screen() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Then("Fills in and Submits User Feedback")
    public void fills_in_and_submits_user_feedback() throws InterruptedException {
        //pisanoPage.zeroLevelRecommend.click();
        name = faker.name().fullName();
        WebElement iFrameElementi = driver.findElement(By.id("psn-widget-content-frame"));
        driver.switchTo().frame(iFrameElementi);
        //pisanoPage.denemeEmoji.click();
        pisanoPage.recommendLevelList.get(0).click();
        pisanoPage.severityLevelList.get(4).click();
        pisanoPage.firstPageNextPageButton.click();
        pisanoPage.clickHereTextBox.sendKeys(name);
        pisanoPage.iDontAcceptRadioButton.click();
        pisanoPage.favoritesOtherCheckBox.click();
        pisanoPage.secondPageNextPageButton.click();

    }
    @Then("Verify that User have been kicked to the first page")
    public void verify_that_user_have_been_kicked_to_the_first_page() throws InterruptedException {
        Assert.assertTrue(pisanoPage.recommendLevelList.get(0).isDisplayed());
        Assert.assertTrue(pisanoPage.severityLevelList.get(4).isDisplayed());

        Driver.quitDriver();

    }

    @Then("Fills in and Submits User pozitive Feedback")
    public void fills_in_and_submits_user_pozitive_feedback() throws InterruptedException {
        WebElement iFrameElementi = driver.findElement(By.id("psn-widget-content-frame"));
        driver.switchTo().frame(iFrameElementi);
        name = faker.name().fullName();
        country = faker.country().name();
        email = faker.internet().emailAddress();
        long min = 900000000000L;
        long max = 909999999999L;
        //phonenumber = String.valueOf(faker.number().numberBetween(min,max));
        String phoneNumber = String.format("90507%d", faker.number().numberBetween(1000000L,9999999L));


        pisanoPage.recommendLevelList.get(10).click();

        pisanoPage.severityLevelList.get(0).click();

        pisanoPage.firstPageNextPageButton.click();

        pisanoPage.clickHereTextBox.sendKeys(name);

        pisanoPage.iHaveReadAnAcceptRadioButton.click();

        pisanoPage.favoritesPisanoCheckBox.click();

        pisanoPage.secondPageNextPageButton.click();

        pisanoPage.emailEnterBox.click();

        pisanoPage.emailEnterBox.sendKeys(email);

        pisanoPage.nameTextBox.click();

        pisanoPage.nameTextBox.sendKeys(name);

        //pisanoPage.phoneCountryDropdownMenu.click();

        //pisanoPage.countrySearchBox.sendKeys(country);

        //pisanoPage.countrySearchBox.sendKeys(Keys.ENTER);

        pisanoPage.phoneNumberWriteBox.click();
        //pisanoPage.phoneNumberWriteBox.clear();
        pisanoPage.phoneNumberWriteBox.sendKeys(phoneNumber);
        Thread.sleep(3000);
        pisanoPage.submitButton.click();


    }

    @And("Verify that user feedback is successful")
    public void verify_that_user_feedback_is_successful() throws InterruptedException {
        Assert.assertTrue(pisanoPage.thanksMessage.isDisplayed());
        //Assert.assertTrue(pisanoPage.thanksMessage.equalsIgnoreCase("Thanks, I think test were succeeded"));


        Thread.sleep(2000);
        Driver.quitDriver();
    }


}
