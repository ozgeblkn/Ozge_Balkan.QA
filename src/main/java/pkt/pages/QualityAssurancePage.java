package pkt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {
    @FindBy(css = "a[href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    private WebElement seeAllQAJobsButton;

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToQAPage() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsButton);
    }
} 