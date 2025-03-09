package pkt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {
    public static void main(String[] args) {
        // ChromeDriver yolunu belirtiyoruz
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\ChromeDriver\\chromedriver.exe");

        // WebDriver nesnesini oluşturuyoruz
        WebDriver driver = new ChromeDriver();

        // useinsider.com'ı aç
        driver.get("https://useinsider.com/");

        // Sayfa başlığını yazdır
        System.out.println("Page title: " + driver.getTitle());

        // Tarayıcıyı kapat
        driver.quit();
    }
}
