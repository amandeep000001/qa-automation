package jobOrder;

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
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.pages.VerifyFieldNewOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3847_VerifyFieldNewOrder extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	VerifyFieldNewOrderPage newOrder;
	public Logger log;
	public void loader() throws IOException {

		log = LogManager.getLogger(TG_3847_VerifyFieldNewOrder.class.getName());

		log = LogManager.getLogger(TG_3859_NewOrderHiring.class.getName());

		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		newOrder = new VerifyFieldNewOrderPage (driver,log); 
	}
	@Test(dataProvider ="TG_3847_Verify_Field_Job_Order")
	public void Tag_VerifyNewOrderbuttonOnHomepage(String url ,String username,String password,String estimatedHours) throws InterruptedException {
		test = extent.createTest("Verify New Order button On Homepage");
		log.info("Started==Verifying New Order button On Homepage");  
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successfully");
		test.log(Status.INFO, "Clicking New order button ");
		newOrder.newOrder();
		test.log(Status.PASS, "New order button click successfully");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifynewOrderbutton(), true ,"  New Order button On Homepage not verify");
		test.log(Status.PASS, "Verifyied New Order button On Homepage ");
		Thread.sleep(3000);

		log.info("Started==Verifying Estimated Daily Hours Field Visible");  
		newOrder.newOrder();
		Thread.sleep(2000);
		Assert.assertEquals(newOrder. verifyEstimatedDailyHoursFieldVisible(), true ," field not verify");
		test.log(Status.PASS, "Estimated Daily Hours fields Visible has been verified");
		Thread.sleep(3000);
	
		log.info("Started==Verify Category Field and Job Title Field Visible ");  
		Thread.sleep(3000);
		Assert.assertEquals(newOrder.verifyCategoryFieldVisibleAndJobTitleFieldVisible(), true ,"Verify Category Field and Job Title Field Not Visible");
		test.log(Status.PASS, "Category Field Visible");
		Thread.sleep(3000);
	
		log.info("Started==Verify Company Field Visible");  
		Assert.assertEquals(newOrder.verifyCompanyFieldVisible(), true ,"Verify Category Field Not Visible");
		test.log(Status.PASS, "Company Field Visible");
		Thread.sleep(3000);
	
		log.info("Started==Verifying Estimated Daily Hours Field should Not Accept Hours More Than 24");  
		test.log(Status.INFO, "Entering estimate daily hours ");
		newOrder.enterEstDailyHours(estimatedHours);
		Thread.sleep(2000);
		test.log(Status.PASS, "Entered estimate daily hours  successfully");
		Assert.assertEquals(newOrder.verifyEstimatedDailyHoursFieldNotAcceptHoursMoreThan24(), true ," field not verify");
		test.log(Status.PASS, "Verifyied Estimated Daily Hours Field should Not Accept Hours More Than 24");
		Thread.sleep(3000);
		test.log(Status.INFO, "closing Estimated Daily Hours DialogBox");
		newOrder.closeEstimatedDailyHoursDialogBox();
		test.log(Status.PASS, "closed Estimated Daily Hours DialogBox successfully");
	}	
	
	@DataProvider(name = "TG_3847_Verify_Field_Job_Order")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3847_Verify_Field_Job_Order");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}