package pkt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeverApplicationPage extends BasePage {
    @FindBy(css = ".application-form")
    private WebElement applicationForm;

    public LeverApplicationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isApplicationFormDisplayed() {
        return isElementDisplayed(applicationForm);
    }
} 