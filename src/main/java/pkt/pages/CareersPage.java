package pkt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class CareersPage extends BasePage {
    @FindBy(css = "a[href='https://useinsider.com/careers/']")
    private WebElement careersLink;

    @FindBy(css = "#career-our-location")
    private WebElement locationsBlock;

    @FindBy(css = "#career-find-our-calling")
    private WebElement teamsBlock;

    @FindBy(css = "#career-life-at-insider")
    private WebElement lifeAtInsiderBlock;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void clickCareersLink() {
        click(careersLink);
    }

    public boolean isCareersPageLoaded() {
        try {
            // Sayfanın yüklenmesi için kısa bir bekleme
            Thread.sleep(3000);
            
            // Sayfanın sonuna kadar kaydır
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            
            // Kaydırma işleminin tamamlanması için bekle
            Thread.sleep(2000);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
} 