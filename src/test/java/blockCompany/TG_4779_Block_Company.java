package blockCompany;

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
import com.sf.pages.BlockCompany;
import com.sf.pages.EmployeeListingPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_4779_Block_Company extends TestBase {

	LoginPage jo;
	// JobOrderPage order;
	Functions functions;
	HomePage homePage;
	Functions fun;
	String JobOrderId;
	BlockCompany block;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4779_Block_Company.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
		block = new BlockCompany(driver, log);
	}
	@Test(dataProvider = "TG_4779_Block_Company")
	public void LoginHiring(String url, String username, String password) throws IOException, InterruptedException { // should
																														// not
																														// be
																														// constructor
		test = extent.createTest("Logging in");
		log.info("Logging in");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successful");
	
	
		log.info("Clicking Staffing Companies");
		Thread.sleep(5000);
		block.clickStaffingCompanies();
		test.log(Status.PASS, "Clicked Staffing Companies successfully");
	
	
		log.info("Verifying Staffing Company List");
		Thread.sleep(4000);
		Assert.assertEquals(block.verifyStaffingCompanyList(), true, " unable to Verify Staffing Companies");
		test.log(Status.PASS, "Verified Staffing Company List Successfully");

	
		log.info("Clicking Staffing Company");
		Thread.sleep(5000);
		
		test.log(Status.INFO,"Clicking on Distance Filter");
		block.clickDistanceFilter();
		test.log(Status.PASS,"Clicked on Distance Filter");
		Thread.sleep(3000);
		
		test.log(Status.INFO,"Clicking on Clear Filter");
		block.clickClearFilter();
		test.log(Status.PASS,"Clicked on Clear Filter");
		Thread.sleep(3000);
		
		block.clickHundredFilter();
		Thread.sleep(3000);
		block.clickStaffingCompany();
		test.log(Status.PASS, "Staffing Company Clicked Successfully");
	
		
		log.info("Clicking Block Button");
		Thread.sleep(3000);
		block.clickBlockButton();
		Thread.sleep(3000);
		test.log(Status.PASS, "Block Button Clicked Successfully");
		
		log.info("Verifying Company Marked as Favorite");
		Assert.assertEquals(block.verifyBlockCompanyPopUp().contains("The rudra staffing is blocked successfully."), true,
				"Company not blicked successfully");
		test.log(Status.PASS, "Verified Staffing Company Blocked Successfully");
		//Thread.sleep(3000);
		block.closePopUpButton();
		Thread.sleep(4000);
		
		log.info("Clicking Unblock Button");
		Thread.sleep(3000);
		block.clickUnblockButton();
		
		test.log(Status.PASS, "Unblock Button Clicked Successfully");
		
		log.info("Verifying Staffing Company UnBlocked");
		//Thread.sleep(40000);
		Assert.assertEquals(block.verifyUnblockCompanyPopUp().contains("The rudra staffing is unblocked successfully."), true,
				"Company not blocked successfully");
		test.log(Status.PASS, "Verified Staffing Company UnBlocked Successfully");
		//Thread.sleep(3000);
		block.closePopUpButton();
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "TG_4779_Block_Company")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_4779_Block_Company"); // data tag from XML
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}