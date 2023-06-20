package employees;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import com.sf.pages.EmployeeListingPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_3963_AddNewEmployee extends TestBase {

	LoginPage jo;
	JobOrderPage order;
	Functions functions;
	AddNewEmployeePage addEmp;
	EmployeeListingPage empList;
	HomePage homePage;
	String newEmployeeEmail = null;
	String employeeId = null;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3963_AddNewEmployee.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		order = new JobOrderPage(driver, log);
		homePage = new HomePage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		empList = new EmployeeListingPage(driver, log);
	}

	@Test(dataProvider = "TG_3963_AddNewEmployee")
	public void VerifyCreateNewEmployee(String url, String username, String password, String companyName,
			String firstName, String lastName, String DOB, String email, String address) throws InterruptedException {
		test = extent.createTest("Verify New Employee Creation");
		log.info("Started==Verifying Company Type  and Company Name are mandatory fields");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		log.info("Login Successful");

		Thread.sleep(3000);
		employeeId = addEmp.addEmployeeFlow(companyName, firstName, lastName, DOB, email, address);

		System.out.println("EmployeeId Of Created employee is " + employeeId);

		Assert.assertEquals(addEmp.verifyNewEmployeeCreation(employeeId), true,
				"New Employee creation failed");
		test.log(Status.PASS, "New Empoyee created successfully");
	
		
		log.info("Verifying Add New Employee discard functionality");
		homePage.clickOnAddEmployeeOnLeftMenu();
		Thread.sleep(20000);
		empList.clickAddNewEployeeButton();
		addEmp.enterCompanyName(companyName);
		addEmp.enterFirstName(firstName);
		addEmp.enterLastName(lastName);
		Thread.sleep(4000);
		addEmp.enterDateOfBirthField(DOB);
		newEmployeeEmail = email + functions.randomNumberGenerator(5) + "@yopmail.com";
		addEmp.enterEmail(newEmployeeEmail);
		//addEmp.selectMilitaryVetranCheckbox();
		addEmp.clickCancelbutton();
		Assert.assertEquals(addEmp.verifyListingPage().contains("Employees"), true,
				"Employee Title is not displayed");
		log.info("Add New Employee discarded successfully");

	
		log.info("Verifying Add New Employee discard functionality");
		Thread.sleep(5000);
		empList.clickAddNewEployeeButton();
		addEmp.clearCompanyFeild();
		addEmp.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertEquals(addEmp.verifyMandatoryFields().contains("First Name"), true,
				"First Name field is not a mandatory field");
		test.log(Status.PASS, "First Name field is verified as a mandatory field");
		Assert.assertEquals(addEmp.verifyMandatoryFields().contains("Last Name"), true,
				"Last Name field is not a mandatory field");
		test.log(Status.PASS, "Last Name field is verified as a mandatory field");
		Assert.assertEquals(addEmp.verifyMandatoryFields().contains("Company"), true,
				"Company field is not a mandatory field");
		test.log(Status.PASS, "Company field is verified as a mandatory field");
		Assert.assertEquals(addEmp.verifyMandatoryFields().contains("Date of Birth"), true,
				"Date of Birth field is not a mandatory field");
		test.log(Status.PASS, "Date of Birth field is verified as a mandatory field");
		Assert.assertEquals(addEmp.verifyMandatoryFields().contains("Email"), true,
				"Email field is not a mandatory field");
		test.log(Status.PASS, "Email field is verified as a mandatory field");
	}
	

	@DataProvider(name = "TG_3963_AddNewEmployee")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3963_AddNewEmployee");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}
