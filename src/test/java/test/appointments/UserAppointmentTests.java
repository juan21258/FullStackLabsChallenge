package test.appointments;

import com.microsoft.playwright.*;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.*;
import pages.*;
import constants.*;

public class UserAppointmentTests {

	private Playwright playwright;
    private Browser browser;
    private Page page;
    private AppointmentPage appointmentPage;
    TestData testData = new TestData();
    
    @BeforeMethod
    public void setup() throws Exception {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterMethod
    public void teardown() throws Exception {
        page.close();
        browser.close();
        playwright.close();
    }
    
    @Test
    public void createAppointment() throws InterruptedException {
    	appointmentPage = new AppointmentPage(page, testData.BASE_URL);
    	appointmentPage.navigate();
    	appointmentPage.enterPetName(testData.PET_NAME);
    	appointmentPage.enterOwner(testData.OWNER_NAME);
    	appointmentPage.enterDate(testData.DATE);
    	appointmentPage.enterTime(testData.TIME);
    	appointmentPage.enterSymptoms(testData.SYMPTOMS);
    	appointmentPage.addAppointment();
    	assertTrue(appointmentPage.checkAppointment());
    }
    
    @Test
    public void deleteAppointment() throws InterruptedException {
    	appointmentPage = new AppointmentPage(page, testData.BASE_URL);
    	appointmentPage.navigate();
    	appointmentPage.enterPetName(testData.PET_NAME);
    	appointmentPage.enterOwner(testData.OWNER_NAME);
    	appointmentPage.enterDate(testData.DATE);
    	appointmentPage.enterTime(testData.TIME);
    	appointmentPage.enterSymptoms(testData.SYMPTOMS);
    	appointmentPage.addAppointment();
    	assertTrue(appointmentPage.checkAppointment());
    	appointmentPage.deleteAppointment();
    }
}
