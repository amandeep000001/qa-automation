package jobOrder;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.sf.base.TestBase;
import com.sf.pages.NewOrderHiringPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3859_NewOrderHiring extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	NewOrderHiringPage hiringOrder;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3859_NewOrderHiring.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		hiringOrder = new NewOrderHiringPage(driver,log); 
	}
	@Test(dataProvider ="TG_3859_Hiring_Job_Order")
	public void Tag_VerifyFieldVisibleAndMandetory(String url ,String username,String password) throws InterruptedException {
		test = extent.createTest("Verify mandatory field");
		log.info("Started==Verifying Mandatory Field");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successfully");
		test.log(Status.INFO, "Clicking New order button ");
		hiringOrder.newOrder();
		test.log(Status.PASS, "New order button click successfully");
		test.log(Status.INFO, "Clicking save button ");
		hiringOrder.clickSave();
		test.log(Status.PASS, "save button clicked successfully");
		Thread.sleep(2000);
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Select Job"), true, "Select Job field is not a mandatory field");
		test.log(Status.PASS, "Select Job field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Industry"), true, "Category field is not a mandatory field");
		test.log(Status.PASS, "Category field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Job Order Start Date"), true, "Job Order Start Date field is not a mandatory field");
		test.log(Status.PASS, "Job Order Start Date field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Job Site"), true, "Job Site field is not a mandatory field");
		test.log(Status.PASS, "Job Site field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Rate"), true, "Rate field is not a mandatory field");
		test.log(Status.PASS, "Rate field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Job Order End Date"), true, "Job Order End Date field is not a mandatory field");
		test.log(Status.PASS, "Job Order End Date field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Job Duration"), true, "Job Duration field is not a mandatory field");
		test.log(Status.PASS, "Job Duration field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Estimated Hours Per Day"), true, "Estimated Hours Per Day field is not a mandatory field");
		test.log(Status.PASS, "Estimated Hours Per Day field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("E-Signature Full Name"), true, "E-Signature Full Name field is not a mandatory field");
		test.log(Status.PASS, "E-Signature Full Name field is verified as a mandatory field");
		Assert.assertEquals(hiringOrder.verifyMandatoryFieldIsBlank().contains("Availability"), true, "Availability field is not a mandatory field");
		test.log(Status.PASS, "Availability field is verified as a mandatory field");
		test.log(Status.PASS, "Mandatory Fields has been verified");
		Thread.sleep(3000);
		hiringOrder.closeBlankMandatoryFieldDialogBox();
	
		log.info("Started==Verify Pop-up");  
		hiringOrder.clickSave();
		Thread.sleep(2000);
		Assert.assertEquals(hiringOrder.verifyPopupForMandatoryFieldIsBlank(), true ,"Pop-up Not Visible");
		test.log(Status.PASS, "Pop-up Visible");
		Thread.sleep(3000);
		hiringOrder.closeBlankMandatoryFieldDialogBox();
	}
	
	@DataProvider(name = "TG_3859_Hiring_Job_Order")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3859_Hiring_Job_Order");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}