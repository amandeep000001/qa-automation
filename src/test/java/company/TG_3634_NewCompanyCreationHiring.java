package company;

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
import com.sf.pages.AddNewCompanyPage;
import com.sf.pages.CompanyListingPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_3634_NewCompanyCreationHiring extends TestBase {
	LoginPage jo;
	JobOrderPage order;
	Functions functions;
	AddNewCompanyPage newCompany;
	CompanyListingPage companyListing;
	HomePage homePage;
	Functions fun;
	String createdCompanyName;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3634_NewCompanyCreationHiring.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		order = new JobOrderPage(driver, log);
		newCompany = new AddNewCompanyPage(driver, log);
		companyListing = new CompanyListingPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();

	}

	@Test(dataProvider = "TG_AddNewCompany")
	public void Tag_VerifyCompanyTypeAndCompanyNameAreAMandatoryFieldsHiring(String url, String username, String password,
			String companyType, String tagCharges, String companyName, String contactName, String url2)
			throws IOException, InterruptedException { // should not be constructor
		test = extent.createTest("Verify Company Type is a mandatory field");
		log.info("Started==Verifying Company Type  and Company Name are mandatory fields");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successful");
		
		test.log(Status.INFO, "Clicking on Company link present on the homepage");
		homePage.clickCompanyLinkOnHomePage();
		test.log(Status.PASS, "Home Page Link clicked successfully");
		Thread.sleep(15000);
		test.log(Status.INFO, "Cliking on Add new button present on the company listing page ");
		companyListing.clickAddNewCompanyButton();
		test.log(Status.PASS, "Add new company button clicked successfully");
		
		test.log(Status.INFO, "Cicking on search field");
		Thread.sleep(5000);
		newCompany.clickonSearchField();
		test.log(Status.PASS, "Search field clicked successfully");
		
		test.log(Status.INFO, "Cicking on Save button");
		newCompany.clickSaveButton();
		Thread.sleep(1000);
		Assert.assertEquals(newCompany.verifyMandatoryFieldIsBlank(), true, "CompanyName is not a mandatory field");
		test.log(Status.PASS, "Company Name and Company Type are mandatory fields has been verified");
		Thread.sleep(3000);
		newCompany.closeBlankMandatoryFieldDialogBox();
	
		
		
		log.info("Started==TAG Add New Company Functionality");
		newCompany.enterCompanytype(companyType);
		Thread.sleep(5000);
		newCompany.enterTagCharges(tagCharges);
		createdCompanyName = companyName + " " + fun.randomStringGenerator(5);
		newCompany.enterCompanyName(createdCompanyName);
		Thread.sleep(1000);
		newCompany.clickSaveButton();
		Thread.sleep(20000);
		System.out.println("Company name is "+createdCompanyName);
		newCompany.waitAfterSaveButtonIsClicked(createdCompanyName);
		Assert.assertEquals(newCompany.verifyNewCompanyCreatedSuccessfully(createdCompanyName), true,
				"New Company was not created");
		test.log(Status.PASS, "New Company Address successfully");
	
		newCompany.goTOCompanyListingPage();
		Thread.sleep(3000);
//		companyListing.clearFilter();
//		test.log(Status.PASS, "New Company was found on listing");
//		Assert.assertEquals(companyListing.findCompanyNameOnListingPage(createdCompanyName), true,
//				"New Company was not created");
	}

	@DataProvider(name = "TG_AddNewCompany")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_AddNewCompanyHiring_3634"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}

}
