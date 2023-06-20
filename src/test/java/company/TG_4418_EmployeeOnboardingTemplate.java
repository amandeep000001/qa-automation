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
import com.sf.pages.StaffingEmpOnboardingTempPage;
import com.sf.pages.StaffingEmpOnboardingPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

@Test

public class TG_4418_EmployeeOnboardingTemplate extends TestBase {
	LoginPage login;
	StaffingHomePage home;
	Functions functions;
	StaffingEmpOnboardingPage emp;
	StaffingEmpOnboardingTempPage emptemp;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4418_EmployeeOnboardingTemplate.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		emptemp = new StaffingEmpOnboardingTempPage(driver, log);
		functions = new Functions();
		emp = new StaffingEmpOnboardingPage(driver, log);
	}

	@Test(dataProvider = "TG_EmployeeOnboardingTemplate")
	public void TG_4027_ClickingSetupUnderATSOption(String url, String username, String password, String templateName,
			String activityname, String userfeild, String document, String pdf)
			throws IOException, InterruptedException {
		test = extent.createTest("TG-4027 Staffing Role should be able to see click the Set Up option under the ATS");
		driver.get(url);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "Clicking on the ATS Menu on Staffing home page");
		home.clickATSMenuOnStaffingHomePage();
		test.log(Status.PASS, "Clicked the ATS Menu on Staffing home page successfully");

		test.log(Status.INFO, "Clicking on the set up option under the ATS menu");
		home.clickSetUpOptionUnderTheATS();
		test.log(Status.PASS, "Clicked the set up option under the ATS menu successfully");

		test.log(Status.INFO, "verifiying EmployeeOnboardingTemplate Title on EmployeeOnboradingTemplate page");
		Assert.assertEquals(emptemp.verifyEmployeeOnboardingTemplateTitle(), true,
				"Verify Employee Onboarding Template Title is visible");
		test.log(Status.PASS, "Verified Form title- Employee Onboarding Template displayed successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO,
				"Clicking on the AddEmployeeOnboarding Template navigates to  New EmployeeOnborading Template");
		emptemp.clickAddEmployeeOnboardingTemplate();
		test.log(Status.PASS, "Clicked the AddEmployeeOnboarding navigated to EmployeeOnborading form successfully");

		test.log(Status.INFO, "verifiying New Employee Onboarding Template title on new EmployeeOnborading page");
		Assert.assertEquals(emptemp.verifyNewEmployeeOnboardingTemplateTitle(), true,
				"Verify new Employee Onboarding Template Title is visible");
		test.log(Status.PASS,
				"Verified  New Employee Onboarding Template title on new EmployeeOnborading page successfully");
	
		Thread.sleep(2000);

		test.log(Status.INFO, "verifiying Company Feild is mandatory in new Employee Onboarding Template");
		Assert.assertEquals(emptemp.verifyCompanyFeildMandatory().contains("Company"), true,
				"Error message is not displayed");
		test.log(Status.PASS, "Verified Company Feild is mandatory in new Employee Onboarding Template successfully");

		test.log(Status.INFO, "verifiying Company Feild auto populated in new Employee Onboarding Template");
		Assert.assertEquals(emptemp.verifyCompanyFeildAutoPopulated(), true,
				"Verify new Employee Onboarding Template Title is visible");
		test.log(Status.PASS, "Verified Company Feild auto populated in new Employee Onboarding Template successfully");
	
		
		test.log(Status.INFO, "Entering email on new EmployeeOnborading page");
		String name = templateName + functions.randomNumberGenerator(5) ;
		emptemp.enterTemplateName(name);
		test.log(Status.PASS, "Entered email on the new EmployeeOnborading page successfully");

		test.log(Status.INFO, "Clicking Add Row button on the form under the Activities Panel");
		emptemp.clickAddRowButton();
		test.log(Status.PASS, "Clicked Add Row button on the form under the Activities Panel successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking edit button on the form under the Activities Panel");
		emptemp.clickEditButton();
		test.log(Status.PASS, "Clicked edit button on the form under the Activities Panel successfully");

		test.log(Status.INFO, "verifiying new Modal should open on clicking edit button");
		Assert.assertEquals(emptemp.verifyEditModal(), true,
				"verifiying new Modal should open on clicking edit button");
		test.log(Status.PASS, "New Modal opened on clicking edit button successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "verifiying Activity name is visible in modal");
		Assert.assertEquals(emptemp.verifyActivityNameModal(), true, "verifiying Activity name is visible in modal");
		test.log(Status.PASS, "Activity name is visible in modal successfully");

		test.log(Status.INFO, "Clicking Dropdown arrow in the modal");
		emptemp.clickDropModalClose();
		test.log(Status.PASS, "Clicked Dropdown arrow in the modal successfully");

		test.log(Status.INFO, "Clicking save button in new Employee Onboarding Template");
		emptemp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button in new Employee Onboarding Template successfully");

		Assert.assertEquals(emptemp.verifyMissingFieldPopUp().contains(" Activities"), true,
				"Error message is not displayed");
	
		Thread.sleep(2000);

		test.log(Status.INFO, "clicking close Icon button ");
		emptemp.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");

		test.log(Status.INFO, "Clicking edit button on the form under the Activities Panel");
		emptemp.clickEditButton();
		test.log(Status.PASS, "Clicked edit button on the form under the Activities Panel successfully");

		test.log(Status.INFO, "Entering Activity name in the Modal");
		emptemp.enterActivityName(activityname);
		test.log(Status.PASS, "Entered Activity name in the Modal successfully");

		test.log(Status.INFO, "verifiy User is visible in Modal");
		Assert.assertEquals(emptemp.verifyUserVisible(), true, "Verify user is visible in Modal");
		test.log(Status.PASS, "Verified User is visible on Modal successfully");

		test.log(Status.INFO, "Entering User feild is visible in Modal");
		emptemp.enterUserFeildValue(userfeild);
		test.log(Status.PASS, "Entered User feild in modal successfully");


		Thread.sleep(2000);

		test.log(Status.INFO, "verifiy document required is visible in Modal");
		Assert.assertEquals(emptemp.verifyDocumentRequiredVisible(), true,
				"Verify document required is visible in Modal");
		test.log(Status.PASS, "Verified document required is displayed Modal successfully");
		Thread.sleep(2000);

		test.log(Status.INFO, "Clicking checkox DocumentRequired in modal");
		emptemp.clickCheckBoxDocumentRequired();
		test.log(Status.PASS, "Clicked checkox DocumentRequired in modal successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "clicking dropdown document in Modal");
		emptemp.enterDocument(document);
		test.log(Status.PASS, "Clicked dropdown document in Modal successfully");

		test.log(Status.INFO, "verifiying attachment auto populated on selecting dropdown value in modal");
		Assert.assertEquals(emptemp.verifyAttachment(), true, "Attachment populated in Modal");
		test.log(Status.PASS, "Verified attachment auto populated on selecting dropdown value in modal successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking attach button in the modal");
		emptemp.clickAttachButton();
		test.log(Status.PASS, "Clicked attach button in the modal successfully");

		test.log(Status.INFO, "Clicking my device button in the modal");
		emptemp.enterMyDevice(pdf);
		test.log(Status.PASS, "My device button clicked in the modal successfully");

		test.log(Status.INFO, "Clicking upload button in the modal");
		emptemp.clickUploadButton();
		test.log(Status.PASS, "Clicked upload button in the modal successfully");

		test.log(Status.INFO, "Clicking Dropdown arrow in the modal");
		emptemp.clickDropModalClose();
		test.log(Status.PASS, "Clicked Dropdown arrow in the modal successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking save button in new Employee Onboarding Template");
		emptemp.clickSaveButton();
		test.log(Status.PASS, "Clicked save button in new Employee Onboarding Template successfully");
	
		Thread.sleep(2000);
		Assert.assertEquals(emptemp.verifyNewEntry().contains("HR-EMP-ONT"), true, "Error message is not displayed");
	}

	@DataProvider(name = "TG_EmployeeOnboardingTemplate")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_EmployeeOnboardingTemplate");
	}

	public void closeSession() throws InterruptedException {
//		driver.quit();
	}
}
