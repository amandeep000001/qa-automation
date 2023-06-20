package jobTitle_jobSite;
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
import com.sf.pages.AddNewEmployeePage;
import com.sf.pages.AddNewUserPage;
import com.sf.pages.ClaimOrderPage;
import com.sf.pages.JobSitePage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingEmpOnboardingPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_4863_JobSiteCreation extends TestBase {
	LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	ClaimOrderPage order;
	Functions functions;
	StaffingEmpOnboardingPage emp;
	JobSitePage jobSite;
	AddNewUserPage addUser;
	String newUserEmail = null;
	AddNewEmployeePage addEmp;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4863_JobSiteCreation.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		functions = new Functions();
		emp = new StaffingEmpOnboardingPage(driver, log);
		jobSite = new JobSitePage(driver, log);
		addUser = new AddNewUserPage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
	}
	@Test(dataProvider = "TG_4863_JobSiteCreation")
	public void TG_4863_VerifyUserRedirectToJobSiteForm(String url, String username, String password, String companyType,
			String userlLastName, String userFirstName, String userEmail, String companyName, String role,
			String address, String title, String mobile) throws IOException, InterruptedException {
		test = extent.createTest("Verify User Should be Redirect to Job Site Listing form and Create a new User");
		driver.get(url);
		
		test.log(Status.INFO,"Entering Username");
		login.enterUsername(username);
		test.log(Status.PASS,"Username Entered Successfully");
		
		
		test.log(Status.INFO,"Entering Password");
		login.enterPassword(password);
		test.log(Status.PASS,"Password Entered Successfully");
		
		test.log(Status.INFO,"Clicking on Login Button");
		login.clickLoginButton();
		test.log(Status.PASS,"Login Button Clicked Successfully");
		
		Thread.sleep(3000);
		test.log(Status.INFO,"Clicking Job Site on Tile on Homepage");
		jobSite.clickJobSiteOnHomepage();
		test.log(Status.PASS,"Job Site on Tile on Homepage Clicked Successfully");
		
		Thread.sleep(5000);
		test.log(Status.INFO,"Clicking Add Job Site Button");
		jobSite.clickAddJobSiteButton();
		test.log(Status.PASS,"Add Job Site Button Clicked Successfully");
		
		Thread.sleep(3000);
		test.log(Status.INFO,"Clicking Create New User Option");
		jobSite.clickCreateNewUserOption();
		test.log(Status.PASS,"Create New User Option Clicked Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO,"Entering Company Type");
		addUser.enterCompanyType(companyType);
		test.log(Status.PASS,"Company Type Entered Successfully");
		
		test.log(Status.INFO,"Clicking Last Name Field");
		addUser.clickLastNameField();
		test.log(Status.PASS,"Last Name Field Clicked Successfully");
		
		Thread.sleep(3000);
		newUserEmail = "automation." + functions.randomNumberGenerator(5) + "@yopmail.com";
		test.log(Status.INFO,"Entering User's Email");
		addUser.enterUserEmail(newUserEmail);
		test.log(Status.PASS,"User's Email Entered Successfully");
		
		test.log(Status.INFO,"Entering User's First Name");
		addUser.enterFirstNameField(userFirstName);
		test.log(Status.PASS,"User's First Name Entered Successfully");
		
		test.log(Status.INFO,"Entering User's Last Name");
		addUser.enterLastNameField(userlLastName);
		test.log(Status.PASS,"User's Last Name Entered Successfully");
		
		test.log(Status.INFO,"Clicking on More Info Tab");
		addUser.cickOnMoreInformationheader();
		test.log(Status.PASS,"More Info Tab Clicked Successfully");
		
		Thread.sleep(1000);
		test.log(Status.INFO,"Clicking Save Button");
		jobSite.clickSavebuttonInAddUser();
		test.log(Status.PASS,"Save Button Clicked Successfully");
		
		Thread.sleep(30000);
		test.log(Status.INFO,"Clicking Close Pop-Up");
		jobSite.clickClosePopUp();
		test.log(Status.PASS,"Pop-Up Closed Successfully");

		Thread.sleep(3000);
		test.log(Status.INFO,"Entering Job Title in Table");
		jobSite.enterJobTitleInTable();
		test.log(Status.PASS,"Job Title in Table Entered Successfully");
		
		test.log(Status.INFO,"Entering Title in Text Field");
		jobSite.enterTitle(title);
		test.log(Status.PASS,"Title in Text Field Entered Successfully");
		Thread.sleep(2000);
		
		test.log(Status.INFO,"Entering Address");
		addEmp.enterEmployeeAddressOnMaps(address);
		test.log(Status.PASS,"Address Added Successfully");
		
		test.log(Status.INFO,"Clicking on Save Button");
		jobSite.clickSaveButton();
		test.log(Status.PASS,"Save Button Clicked Successfully");
		
		jobSite.clickSaveButton();
		
		test.log(Status.INFO,"Verifying Job Site Created Successfully or Not");
		Assert.assertEquals(jobSite.verifyCreatedSite().contains("New York, NY 10020, USA"), true, "Error message is not displayed");
		test.log(Status.PASS,"Job Site Created Successfully");
		
	}
	@DataProvider(name = "TG_4863_JobSiteCreation")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_4863_JobSiteCreation");
	}
	public void closeSession() throws InterruptedException {
		 driver.quit();
	}
}