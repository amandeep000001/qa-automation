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
import com.sf.pages.DeleteJobOrderPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class DeleteJobOrder extends TestBase {

	LoginPage jo;
	Functions functions;
	AddNewCompanyPage newCompany;
	CompanyListingPage companyListing;
	HomePage homePage;
	Functions fun;
	String createdCompanyName;
	DeleteJobOrderPage deleteJobOrder;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3634_NewCompanyCreationFromStaffing.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);

        //order = new Job_Order_Page(driver, log);

		newCompany = new AddNewCompanyPage(driver, log);
		companyListing = new CompanyListingPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
		deleteJobOrder = new DeleteJobOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_DeleteJobOrderHiring") 
	public void Tag_3911_VerifyDeleteJobOrder(String url, String username, String password) // This test contains all the tests mentioend in the Delete workflow on zephyre
			throws IOException, InterruptedException { // should not be constructor
		test = extent.createTest("TG-3911 Verify Delete Job Order");
		log.info("Started==Login");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.INFO, "Login Successful");
		
		test.log(Status.INFO, "Clickgin Job order link on homepage");
		deleteJobOrder.clickJobOrderLinkOnHomePage();
		test.log(Status.INFO, "Job order button on homepage clicked");
		
		test.log(Status.INFO, "Selecting jobn order for deletion");
		String jobOrderId = deleteJobOrder.selectJobOrderOnlistingPage();
		test.log(Status.INFO, "Job order selected for deletion");
		
		test.log(Status.INFO, "Clicking Job order delete button");
		deleteJobOrder.clickDeleteJobOrderButton();
		test.log(Status.INFO, "Delete Job order button clicked");
		
		test.log(Status.INFO, "Clicking on discard job order button");
		deleteJobOrder.clickRejectDeleteJobOrderRequestButton();
		test.log(Status.INFO, "Delete job order request discarded");
		
		test.log(Status.INFO, "Clicking Job order delete button ");
		deleteJobOrder.clickDeleteJobOrderButton();
		test.log(Status.INFO, "Delete Job order button clicked");
		
		test.log(Status.INFO, "Clicking on confirm Job order deletion button");
		deleteJobOrder.clickAcceptDeleteJobOrderRequestButton();
		test.log(Status.INFO, "Job order deletion request confirmed");
		Assert.assertEquals(deleteJobOrder.verifyJobOrderDeletion(jobOrderId), false,
				"Job Order having job id as " + jobOrderId + " deletion is not successful");
		test.log(Status.PASS, "ob Order having job id as " + jobOrderId + " deletion is successful");
	}

	@DataProvider(name = "TG_DeleteJobOrderHiring")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_DeleteJobOrderHiring"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}

}