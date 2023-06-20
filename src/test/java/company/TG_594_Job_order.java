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
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.Log;
import com.sf.utility.XmlReader;

public class TG_594_Job_order extends TestBase {

	LoginPage jo;
	JobOrderPage order;
	Functions functions;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_594_Job_order.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		order  = new JobOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_234_Login")
	public void TG_234_Login(String url, String username, String password)throws IOException, InterruptedException {
		test = extent.createTest("TG-234 Login Functionality");
		log.info("Started==TAG Login Functionality");
		driver.get(url);
		log.info("Logging into the application using username: " + username);
		test.log(Status.INFO, "Logging into the application using username: " + username);

		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		Assert.assertEquals(jo.checkLoginSuccessfully(), true, "User unable to login");
		log.info("User: " + username + " logged in successfully");
		test.log(Status.PASS, "User " + username + " logged in successfully");
	
		order.clickNewOrder();
		order.enterCategory("Administrative/Clerical");
		order.enterJobTitle("Administrative Service");
		order.enterStartDate("09-07-2022");
		Thread.sleep(2000);
		order.enterEndDate("09-10-2022");
		Thread.sleep(2000);
		order.enterStartTime("20:10");
		Thread.sleep(2000);
		order.enterEstDailyHours("8");
		Thread.sleep(2000);
		order.enterAvailability();
		order.enterJobSite("Lake Butler, FL 32054, USA");
		order.enterNoOfWorkers("10");
		order.enterDrivingRecordPrice();
		order.enterExtraPrice("12");
		order.enterESignature("Hiring Admin");
		order.clickAgreeContract();
		order.clickSave();
		Thread.sleep(2000);
		order.clickConfirm();
		Thread.sleep(2000);
		order.clickConfirm2();
		Assert.assertEquals(order.checkJobOrderCreation(), true, "Unable to create Job Order");
		
		
	}
	
	

	@DataProvider(name = "TG_234_Login")
	public Object[][] flipkart() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_234_Login");
	}
	

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}
