package pkt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class JobsPage extends BasePage {
    @FindBy(id = "select2-filter-by-location-container")
    private WebElement locationFilter;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement departmentFilter;

    @FindBy(css = ".position-list-item")
    private List<WebElement> jobListings;

    @FindBy(css = ".position-title")
    private List<WebElement> positionTitles;

    @FindBy(css = ".position-department")
    private List<WebElement> positionDepartments;

    @FindBy(css = ".position-location")
    private List<WebElement> positionLocations;

    @FindBy(css = ".btn-position-apply")
    private WebElement viewRoleButton;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void selectLocation(String location) {
        // Lokasyon filtresinin tıklanabilir olmasını bekle
        wait.until(ExpectedConditions.elementToBeClickable(locationFilter));
        click(locationFilter);
        
        // Lokasyon seçeneğinin görünür olmasını bekle
        WebElement locationOption = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'select2-results__option') and contains(text(), '" + location + "')]")));
        
        // Lokasyon seçeneğinin tıklanabilir olmasını bekle
        wait.until(ExpectedConditions.elementToBeClickable(locationOption));
        click(locationOption);
    }

    public void selectDepartment(String department) {
        // Departman filtresinin tıklanabilir olmasını bekle
        wait.until(ExpectedConditions.elementToBeClickable(departmentFilter));
        click(departmentFilter);
        
        // Departman seçeneğinin görünür olmasını bekle
        WebElement departmentOption = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'select2-results__option') and contains(text(), '" + department + "')]")));
        
        // Departman seçeneğinin tıklanabilir olmasını bekle
        wait.until(ExpectedConditions.elementToBeClickable(departmentOption));
        click(departmentOption);
    }

    public boolean verifyJobListings() {
        // İş listesinin yüklenmesini bekle
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".position-list-item")));
        
        for (int i = 0; i < jobListings.size(); i++) {
            String position = getText(positionTitles.get(i));
            String department = getText(positionDepartments.get(i));
            String location = getText(positionLocations.get(i));

            if (!position.contains("Quality Assurance") ||
                !department.contains("Quality Assurance") ||
                !location.contains("Istanbul, Turkey")) {
                return false;
            }
        }
        return true;
    }

    public void clickViewRole() {
        // View Role butonunun tıklanabilir olmasını bekle
        wait.until(ExpectedConditions.elementToBeClickable(viewRoleButton));
        click(viewRoleButton);
    }
} 