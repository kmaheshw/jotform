package com.JetForm.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.JotForm.base.TestBase;
import com.JotForm.pages.JotFormPage;


public class JotFormPageTest extends TestBase {

	JotFormPage jotFormPage;

	public JotFormPageTest() {
		super();

	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		jotFormPage = new JotFormPage();
		// testUtil = new TestUtil();
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest(){ //Method to verify home page title
		String homePageTitle = jotFormPage.verifyPageTitle();
		String message="Actual title is " + homePageTitle;
		Assert.assertEquals(homePageTitle, "Hotel Booking Form", message);
	}
	
	@Parameters({ "fName", "lName" ,"emailId", "roomTypeEntry", "NumberOfGuest","ArrivalDate","departureMonth","departureDay", "departureYear","flight","specialRequest"})
	@Test(priority=1)
	public void EnterFormInformation(String fName,String lName,String emailId, String roomTypeEntry, String NoOfGuest,String ArrivalDate,String departureMonth,String departureDay, String departureYear,String flight,String specialRequest) throws AWTException{ //Method to verify home page title
		jotFormPage.fillForm(fName,lName,emailId,roomTypeEntry,NoOfGuest,ArrivalDate,departureMonth,departureDay,departureYear,flight,specialRequest);
		
		
	}
	
	@Test(priority=2)
	public void verifyTitleTest(){ //Method to verify home page title
		String homePageTitle = jotFormPage.verifyPageTitle();
		String message="Actual title is " + homePageTitle;
		Assert.assertEquals(homePageTitle, "Thank You", message);
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	

}