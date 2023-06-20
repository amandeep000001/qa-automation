package company;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.sf.base.TestBase;
import com.sf.pages.ClaimOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingEmpOnboardingPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

@Test
public class TG_4355_EmployeeOnboarding extends TestBase {
    LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	ClaimOrderPage order;
	Functions functions;
	StaffingEmpOnboardingPage emp;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4355_EmployeeOnboarding.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		functions = new Functions();
		emp = new StaffingEmpOnboardingPage(driver, log);
   }
   @Test(dataProvider = "EmployeeOnboarding")
   public void TG_4015_Verify_SR_AbleToSeeATSOptionAndTwoSubOption(String url, String username, String password,
			String firstname, String lastname, String email, String employeeonboardingtemplate, String dateOfBirth, String data1, String data2, String currentYearDOB)
			throws IOException, InterruptedException {
		test = extent.createTest("TG-4015 Staffing Role should be able to see the ATS option in the left navigation having 2 sub options as - Onboarding and Set Up");
		driver.get(url);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "Clicking on the ATS Menu on Staffing home page");
		home.clickATSMenuOnStaffingHomePage();
		test.log(Status.PASS, "Clicked the ATS Menu on Staffing home page successfully");

		test.log(Status.INFO, "verifiying Onboarding Menu on Staffing home page");
		Assert.assertEquals(home.verifyOnboardingMenuOnStaffingHomePage(), true,"Verify OnboardingMenu is visible on the homepage");
		test.log(Status.PASS, "Verify OnboardingMenu is visible on the Staffing home page successfully");

		test.log(Status.INFO, "verifiying SetUp on Staffing home page");
		Assert.assertEquals(home.verifySetUpMenuOnStaffingHomePage(), true,"Verify SetUp Menu is visible on the homepage");
		test.log(Status.PASS, "Verified SetUp menu is visible on the Staffing home page successfully");

		test.log(Status.INFO, "Clicking on the Onboarding Menu on Staffing home page");
		home.clickOnboardingMenuOnStaffingHomePage();
		test.log(Status.PASS, "Clicked the Onboarding Menu on Staffing home page successfully");
		Thread.sleep(2000);

		test.log(Status.INFO, "verifiying EmployeeOnboardingTitle on EmployeeOnborading page");
		Assert.assertEquals(emp.verifyEmployeeOnboardingTitle(), true,"EmployeeOnboardingTitle is visible on EmployeeOnborading page");
		test.log(Status.PASS, "Verified Form title- Employee Onboarding successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on the AddEmployeeOnboarding navigates to  EmployeeOnborading form");
		emp.clickAddEmployeeOnboarding();
		test.log(Status.PASS, "Clicked the AddEmployeeOnboarding navigated to EmployeeOnborading form successfully");

		test.log(Status.INFO, "verifiying NewEmployeeOnboardingTitle on new EmployeeOnborading page");
		emp.verifyNewEmployeeOnboardingTitle();
		test.log(Status.PASS, "Verified NewEmployeeOnboardingTitle on new EmployeeOnborading page successfully");

		
		test.log(Status.INFO,"Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS,"Clicked save button on the new EmployeeOnborading page successfully");
		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields:"), true,"Error message is not displayed");
		
		test.log(Status.INFO, "Clicking close button on the new EmployeeOnborading page");
		emp.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS, "Clicked close button on the new EmployeeOnborading page successfully");
	
		
		test.log(Status.INFO, "verifiy FirstName is visible on new EmployeeOnborading page");
		Assert.assertEquals(emp.verifyFirstNameIsVisible(), true,"Verify FirstName is visible on new EmployeeOnborading page");
		test.log(Status.PASS, "Verified FirstName is visible on new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button on the new EmployeeOnborading page successfully");
		Thread.sleep(2000);

		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields:"), true,"Error message is not displayed");
		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("First Name"), true,"Error message is not displayed");

		test.log(Status.INFO, "Clicking close button on the new EmployeeOnborading page");
		emp.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS, "Clicked close button on the new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Entering first name on new EmployeeOnborading page");
		emp.enterFirstName(firstname);
		test.log(Status.PASS, "Entered first name on the new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
		test.log(Status.INFO, "verifiy last name is visible on new EmployeeOnborading page");
		Assert.assertEquals(emp.verifyLastNameIsVisible(), true,"Verify last is visible on new EmployeeOnborading page");
		test.log(Status.PASS, "Verified last name is visible on new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button on the new EmployeeOnborading page successfully");
		Thread.sleep(2000);

		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields:"), true,"Error message is not displayed");
		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Last Name"), true,"Error message is not displayed");

		test.log(Status.INFO, "Clicking close button on the new EmployeeOnborading page");
		emp.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS, "Clicked close button on the new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Entering last name on new EmployeeOnborading page");
		emp.enterLastName(lastname);
		test.log(Status.PASS, "Entered last name on the new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
		test.log(Status.INFO, "verifiy email is visible on new EmployeeOnborading page");
		Assert.assertEquals(emp.verifyEmailVisible(), true, "Verify email is visible on new EmployeeOnborading page");
		test.log(Status.PASS, "Verified email is visible on new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button on the new EmployeeOnborading page successfully");
		Thread.sleep(2000);

		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields:"), true,"Error message is not displayed");
		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Email"), true, "Error message is not displayed");

		test.log(Status.INFO, "Clicking close button on the new EmployeeOnborading page");
		emp.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS, "Clicked close button on the new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Entering email on new EmployeeOnborading page");
		String userEmail = email + functions.randomNumberGenerator(5) + "@yopmail.com";
		emp.enterEmail(userEmail);
		test.log(Status.PASS, "Entered email on the new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);

		test.log(Status.INFO, "verifiy Employee Onboarding Template is visible on new EmployeeOnborading page");
//		Assert.assertEquals(emp.verifyEmployeeOnboardingTemplateVisible(), true,"Verify last is visible on new EmployeeOnborading page");
		test.log(Status.PASS,"Verified Employee Onboarding Templat is visible on new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button on the new EmployeeOnborading page successfully");
		Thread.sleep(2000);

		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields:"), true,"Error message is not displayed");
		Assert.assertEquals(emp.verifyMissingFieldPopUp().contains("Template Name"), true,"Error message is not displayed");

		test.log(Status.INFO, "Clicking close button on the new EmployeeOnborading page");
		emp.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS,"Clicked close button on the new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Entering Employee Onboarding Template Value on new EmployeeOnborading page");
		emp.enterEmployeeOnboardingTemplateValue(employeeonboardingtemplate);
		test.log(Status.PASS,"Entered Employee Onboarding Template Value on the new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
		
		test.log(Status.INFO, "Entering current year DOB on new EmployeeOnborading page");
		emp.enterDateOfBirth(currentYearDOB);
		test.log(Status.PASS, "Entered current year DOB on the new EmployeeOnborading page successfully");
		Assert.assertEquals(emp.verifyBirthYearErrorMessage().contains("Birth Year must be earlier than this year."), true,"Error message is not displayed");
		
		test.log(Status.INFO, "clicking close Icon button ");
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");
		
		test.log(Status.INFO, "Entering Date Of Birth on new EmployeeOnborading page");
		emp.enterDateOfBirth(dateOfBirth);
		test.log(Status.PASS, "Entered Date Of Birth on the new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking save button on the new EmployeeOnborading page");
		emp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button on the new EmployeeOnborading page successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "verify clicking Save button moved to Draft Status on form new EmployeeOnborading page");
		Assert.assertEquals(emp.verifyDraftStatusOnForm(), true,"Verify draft status is visible on new EmployeeOnborading page");
		test.log(Status.PASS,"verify clicking Save button moved to Draft Status on form new EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
		test.log(Status.INFO, "verify submit is present on the EmployeeOnborading page");
		Assert.assertEquals(emp.verifySubmitButtonOnForm(), true,"Verify submitButton is visible on EmployeeOnborading page");
		test.log(Status.PASS, "verify submit button is visible on EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking submit button on the EmployeeOnborading page");
		emp.clickSubmitButton();
		test.log(Status.PASS, "Clicked submit button on the EmployeeOnborading page successfully");

		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking yes button on confirm modal Employee Onboarding form");
		emp.clickModalConfirmYesButton();
		test.log(Status.PASS, "Clicked yes button on confirm modal Employee Onboarding form successfully");
		
		Thread.sleep(3000);
		test.log(Status.INFO, "verify clicking submit button moved to pending Status on form EmployeeOnborading page");
		Assert.assertEquals(emp.verifySubmittedStatusOnForm(), true,"Verify pending status is visible on new EmployeeOnborading page");
		test.log(Status.PASS,"verify clicking submit button moved to pending Status on form EmployeeOnborading page successfully");
	
		Thread.sleep(3000);
	
		test.log(Status.INFO, "entering Job Applicant List in the search box");
		emp.enterData1(data1);
		test.log(Status.PASS, "Entered Job Applicant List in the search box successfully");
		
		test.log(Status.INFO, "Clicking Job Applicant List in the search box");
		emp.clickSearchBox();
		test.log(Status.PASS, "Clicked Job Applicant List in the search box successfully");
		
		test.log(Status.INFO, "verifiy Job Applicant List is listed with accepted status");
		Assert.assertEquals(emp.verifyJobApplicantList(), true,"Verify Job Applicant List is visible on Job Applicant page");
		test.log(Status.PASS, "Verified Job Applicant List is listed with accepted status successfully");
   
		Thread.sleep(3000);
		test.log(Status.INFO, "entering Job Offer List in the search box");
		emp.enterData1(data2);
		test.log(Status.PASS, "Entered Job Offer List in the search box successfully");
		
		test.log(Status.INFO, "Clicking Job Offer List in the search box");
		emp.clickSearchBox();
		test.log(Status.PASS, "Clicked Job Offer List in the search box successfully");
		
		test.log(Status.INFO, "verifiy Job offer List is listed with draft status");
		Assert.assertEquals(emp.verifyJobOfferList(), true,"Verify Job offer List is visible on Job offer page");
		test.log(Status.PASS, "Verified Job offer List is listed with draft status successfully");
    }
    @DataProvider(name = "EmployeeOnboarding")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_EmployeeOnboarding");
	}
    public void closeSession() throws InterruptedException {
//		driver.quit();
	}
}
