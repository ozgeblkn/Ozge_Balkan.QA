package pkt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Company')]")
    private WebElement companyMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://useinsider.com/");
    }

    public boolean isPageLoaded() {
        // Sayfanın yüklenmesi için biraz bekleyelim
        try {
            wait.until(ExpectedConditions.titleContains("Insider"));
        } catch (Exception e) {
            System.out.println("Actual page title: " + driver.getTitle());
            return false;
        }
        
        // Sayfanın tamamen yüklenmesini bekleyelim
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
        
        // Cookie banner'ı varsa kapatalım (bu navigasyonu engelleyebilir)
        try {
            WebElement acceptCookies = driver.findElement(By.id("wt-cli-accept-all-btn"));
            if (acceptCookies.isDisplayed()) {
                acceptCookies.click();
            }
        } catch (Exception e) {
            // Cookie banner yok, sorun değil
        }
        
        return driver.getTitle().contains("Insider") || 
               driver.getCurrentUrl().contains("useinsider.com");
    }

    public void clickCompanyMenu() {
        // Önce menünün görünür olmasını bekleyelim
        wait.until(ExpectedConditions.elementToBeClickable(companyMenu));
        // Sonra tıklayalım
        click(companyMenu);
    }
} 