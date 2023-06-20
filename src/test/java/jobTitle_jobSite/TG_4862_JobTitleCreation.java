package jobTitle_jobSite;

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
import com.sf.pages.JobTitlePage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingEmpOnboardingPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

import company.TG_4355_EmployeeOnboarding;

public class TG_4862_JobTitleCreation extends TestBase {
	LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	ClaimOrderPage order;
	Functions functions;
	StaffingEmpOnboardingPage emp;
	JobTitlePage jobTitle;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4862_JobTitleCreation.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		functions = new Functions();
		emp = new StaffingEmpOnboardingPage(driver, log);
		jobTitle = new JobTitlePage(driver, log);
	}

	@Test(dataProvider = "TG_4862_JobTitleCreation")
	public void VerifyUserRedirectToJobTitleForm(String url, String username, String password, String jobTitleList,
			String industry, String rate, String title, String description) throws IOException, InterruptedException {
		test = extent.createTest("Verify User Should be Redirect to Job Title Listing form.");
		driver.get(url);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "Clicking Search Bar and entering Job Title List");
		jobTitle.enterJobTitleInSearchBar(jobTitleList);
		test.log(Status.PASS, "Clicked Search Bar and entering Job Title List");

		test.log(Status.INFO, "verifiying Clicking on Job Title List option");
		jobTitle.clickSearchBox();
		test.log(Status.PASS, "Verify Job Title List option clicked successfully");

		test.log(Status.INFO, "verifiying Job Title Listing Form");
		Assert.assertEquals(jobTitle.verifyJobTitleListingPage(), true, "Verify Job Order Listing form Title");
		test.log(Status.PASS, "Verified Job Order Listing form Titlesuccessfully");
	
		
		test.log(Status.INFO, "Clicking Add Job Title Button");
		jobTitle.clickAddJobTitleButton();
		test.log(Status.PASS, "Add Job Title Button Successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking save button on the new Job Title Page");
		jobTitle.clickSaveButton();
		Thread.sleep(3000);
		test.log(Status.PASS, "Clicked save button on the new Job Title Page successfully");
		Assert.assertEquals(
				jobTitle.verifyMissingFieldPopUp().contains("Please Fill Mandatory Fields to create a Job Title:"),
				true, "Error message is not displayed");
		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking close button on the Job Title Page");
		jobTitle.clickCloseButtonMissingFieldPopUp();
		test.log(Status.PASS, "Clicked close button on the Job Title Page successfully");

		test.log(Status.INFO, "Entering Industry");
		jobTitle.enterIndustry(industry);
		test.log(Status.PASS, " Industry Entered Successfully");

		test.log(Status.INFO, "Entering Rate");
		jobTitle.enterRate(rate);
		test.log(Status.PASS, " Industry Entered Successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "Entering Job Title");
		String userJobTitle = title + " " + functions.randomNumberGenerator(5);
		jobTitle.enterJobTitle(userJobTitle);
		Thread.sleep(5000);
		test.log(Status.INFO, "Job Title Entered Successfully");
		test.log(Status.INFO, "Entering Description");
		jobTitle.enterDescription(description);
		test.log(Status.PASS, "Description Entered Successfully");

		test.log(Status.INFO, "Clicking on Save Button");
		jobTitle.clickSaveButton();
		Assert.assertEquals(jobTitle.verifyEnabledTitle().contains("Enabled"), true, "Error message is not displayed");

	}

	@DataProvider(name = "TG_4862_JobTitleCreation")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_4862_JobTitleCreation");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}
