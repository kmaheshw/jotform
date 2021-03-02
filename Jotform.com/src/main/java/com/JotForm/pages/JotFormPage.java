package com.JotForm.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.JotForm.base.TestBase;
import com.JotForm.util.TestUtil;

 

public class JotFormPage extends TestBase {


	@FindBy(xpath = "//input[@id='first_16']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last_16']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='q17_email17']")
	WebElement email;

	@FindBy(xpath = "//select[@name='q6_roomType']")
	WebElement roomType;

	@FindBy(xpath = "//div[@class='form-spinner-button form-spinner-up']")
	WebElement NumberOfGuest;

	@FindBy(xpath = "//input[@id='lite_mode_22']")
	WebElement ArrivalDateTime;

	@FindBy(xpath = "//select[@id='input_20_month']")
	WebElement DepartureDateMonth;

	@FindBy(xpath = "//select[@id='input_20_day']")
	WebElement DepartureDateDay;

	@FindBy(xpath = "//select[@id='input_20_year']")
	WebElement DepartureDateYear;

	@FindBy(css ="#label_input_10_0")
	WebElement freePickupOption;
	
	
	@FindBy(xpath = "//button[@id='input_2']")
	WebElement submitButton;
	
	@FindBy(xpath="//p[text()='Your submission has been received.']")
	WebElement successMessage;
	
	@FindBy(xpath="//div[@class='inputContainer']")
	WebElement fileUpload;
	
	@FindBy(xpath="//input[@id='input_28']")
	WebElement flightNumber;
	
	@FindBy(xpath="//textarea[@id='input_30']")
	WebElement specialRequestInfo;
	
	String fileLocation=System.getProperty("user.dir") +"/resources/img.jpg";
	
	// Initializing the Page Objects:
	public JotFormPage() {
		PageFactory.initElements(driver, this);
	}

	// Title validation
	public String verifyPageTitle() {

		return driver.getTitle();
	}

	public void fillForm(String fName, String lName, String emailId, String roomTypeEntry, String NoOfGuest,
			String ArrivalDate, String departureMonth, String departureDay, String departureYear,String flight,String specialRequest) throws AWTException {

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		TestUtil.selectElement(roomType, roomTypeEntry);
		NumberOfGuest.click();
		NumberOfGuest.click();
		((JavascriptExecutor)driver).executeScript ("document.getElementById('lite_mode_22').removeAttribute('readonly',0);"); // Enables the form date box
		ArrivalDateTime.sendKeys(ArrivalDate);

		TestUtil.selectElement(DepartureDateMonth, departureMonth);
		TestUtil.selectElement(DepartureDateDay, departureDay);
		TestUtil.selectElement(DepartureDateYear, departureYear);
		TestUtil.actionClick(freePickupOption);

		flightNumber.sendKeys(flight);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", specialRequestInfo);
		specialRequestInfo.sendKeys(specialRequest);
		
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		fileUpload.sendKeys(fileLocation);
		
		submitButton.submit();
	}

}
