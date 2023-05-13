package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;


public class AppointmentPage {
	private Page page;
	private String pageUrl;
	
	ElementHandle petInput;
	ElementHandle ownerInput;
	ElementHandle datePicker;
	ElementHandle timePicker;
	ElementHandle symptomsInput;
	ElementHandle addAppointmentBtn;
	ElementHandle appointmentInfo;
	ElementHandle deleteAppointmentBtn;

	public AppointmentPage(Page page, String pageUrl) {
		this.page = page;
		this.pageUrl = pageUrl;
	}
	
	public void navigate() {
		page.navigate(pageUrl);
		setupElements();
	}
	
	private void setupElements() {
		petInput = page.querySelector("input[data-testid='pet']");
		ownerInput = page.querySelector("input[data-testid='owner']");
		datePicker = page.querySelector("input[data-testid='date']");
		timePicker = page.querySelector("input[data-testid='time']");
		symptomsInput = page.querySelector("textarea[data-testid='symptoms']");
		addAppointmentBtn = page.querySelector("button[data-testid='btn-submit']");
	}
	
	public void enterPetName(String petName) {
		petInput.fill(petName);
	}
	
	public void enterOwner(String ownerName) {
		ownerInput.fill(ownerName);
	}
	
	public void enterDate(String date) {
		datePicker.click();
		datePicker.waitForElementState(ElementState.ENABLED);
		datePicker.type(date);
	}
	
	public void enterTime(String time) {
		timePicker.click();
		timePicker.waitForElementState(ElementState.ENABLED);
		timePicker.type(time);
	}
	
	public void enterSymptoms(String enterSymptoms) {
		symptomsInput.type(enterSymptoms);
	}
	
	public void addAppointment() {
		addAppointmentBtn.click();
	}
	
	public boolean checkAppointment() {
		appointmentInfo = page.querySelector("div[data-testid='appointment']");
		return appointmentInfo.isVisible();
	}
	
	public void deleteAppointment() {
		deleteAppointmentBtn = page.querySelector("button.delete");
		deleteAppointmentBtn.click();
	}
}
