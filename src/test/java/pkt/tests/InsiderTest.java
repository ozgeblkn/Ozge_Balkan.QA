package pkt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pkt.pages.*;

public class InsiderTest extends BaseTest {
    private HomePage homePage;
    private CareersPage careersPage;
    private QualityAssurancePage qaPage;
    private JobsPage jobsPage;
    private LeverApplicationPage leverPage;

    @Test
    public void testInsiderCareerFlow() {
        // Adım 1: Ana sayfayı ziyaret et ve açıldığını kontrol et
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        
        // Sayfanın yüklenmesi için biraz daha zaman tanıyalım
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");

        // Initialize other page objects
        careersPage = new CareersPage(driver);
        qaPage = new QualityAssurancePage(driver);
        jobsPage = new JobsPage(driver);
        leverPage = new LeverApplicationPage(driver);

        // Step 2: Navigate to Careers page and verify blocks
        homePage.clickCompanyMenu();
        careersPage.clickCareersLink();
        Assert.assertTrue(careersPage.isCareersPageLoaded(), "Careers page blocks are not displayed");

        // Step 3: Navigate to QA page and click See all QA jobs
        qaPage.navigateToQAPage();
        qaPage.clickSeeAllQAJobs();

        // Step 4: Apply filters
        jobsPage.selectLocation("Istanbul, Turkey");
        jobsPage.selectDepartment("Quality Assurance");

        // Step 5: Verify job listings
        Assert.assertTrue(jobsPage.verifyJobListings(), "Job listings do not match the criteria");

        // Step 6: Click View Role and verify Lever Application form
        jobsPage.clickViewRole();
        Assert.assertTrue(leverPage.isApplicationFormDisplayed(), "Lever Application form is not displayed");
    }
} 