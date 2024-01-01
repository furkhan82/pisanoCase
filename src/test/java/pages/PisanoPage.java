package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class PisanoPage {
    public PisanoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//iframe[@id='psn-widget-button-frame']")
    public WebElement iframeLogin;

    @FindBy(xpath = "//div[@class='button button--nps']")
    public List<WebElement> recommendLevelList;

    @FindBy(xpath = "//img[@class='emojione']")
    public List<WebElement> severityLevelList;

    @FindBy(xpath = "//input[@placeholder='Click here']")
    public WebElement clickHereTextBox;

    @FindBy(xpath = "(//div[@class='button__check is-radio'])[1]")
    public WebElement iHaveReadAnAcceptRadioButton;

    @FindBy(xpath = "(//div[@class='button__check is-radio'])[2]")
    public WebElement iDontAcceptRadioButton;


    @FindBy(xpath = "(//div[@class='button__check is-checkbox'])[1]")
    public WebElement favoritesPisanoCheckBox;

    @FindBy(xpath = "(//div[@class='button__check is-checkbox'])[2]")
    public WebElement favoritesOtherCheckBox;

    @FindBy(id = "5ef0f5ea-2495-435a-9cdd-11ea7f5f93b7")
    public WebElement secondPageNextPageButton;

    @FindBy(id = "1f30269f-7aa9-4c9c-b087-547422a389f4")
    public WebElement firstPageNextPageButton;

    @FindBy(xpath = "//(div[@class='button button--nps'])[1]")
    public WebElement zeroLevelRecommend;

    @FindBy(xpath = "//div[@value='263dfbb1-9261-4f58-a0b4-4546cd8fa2fe']")
    public WebElement denemeEmoji;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailEnterBox;

    @FindBy(xpath ="//input[@type='text']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//div[@class='arrow']")
    public WebElement phoneCountryDropdownMenu;

    @FindBy(xpath = "//input[@class='search-box']")
    public WebElement countrySearchBox;

    @FindBy(xpath = "//*[@placeholder='Enter a valid phone number including area code']")
    public WebElement phoneNumberWriteBox;

    @FindBy(xpath = "//div[@id='4d805800-70e6-4417-8c31-63b5f9b54e99']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[text()[normalize-space()='Thanks, I think test were succeeded']]")
    public WebElement thanksMessage;


}
