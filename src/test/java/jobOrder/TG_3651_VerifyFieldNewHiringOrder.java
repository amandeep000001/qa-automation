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
import com.sf.pages.VerifyFieldNewHiringOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3651_VerifyFieldNewHiringOrder extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	VerifyFieldNewHiringOrderPage verifyField;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3651_VerifyFieldNewHiringOrder.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		verifyField = new VerifyFieldNewHiringOrderPage(driver, log); 
	}
	@Test(dataProvider ="TG_3851_Verify_Field")
	public void Tag_VerifyAvailabilityFieldShouldBeDropdownField(String url ,String username,String password) throws InterruptedException {
		test = extent.createTest("Verify Availability Field Should Be Dropdown Field");
		log.info("Started==Verifying Availability Field Should Be Dropdown Field");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successfully");
		test.log(Status.INFO, "Clicking New order button ");
		verifyField.newOrder();
		test.log(Status.PASS, "New order button click successfully");
		Thread.sleep(3000);
		Assert.assertEquals(verifyField.verifyAvailabilityFieldShouldDropdownField(),true ,"Field Not Verify");
		test.log(Status.PASS, "Verifyied Availability Field Should Be Dropdown Field");
		Thread.sleep(3000);
	
		log.info("Started==Verifying Rate Field Should be Automatically Fetched And Editable");
		Thread.sleep(3000);
        Assert.assertEquals(verifyField.verifyRateFieldAutomaticallyFetchedAndEditable(), true, "Field Not Verify");
		test.log(Status.PASS, "Verifyied Rate Field Should be Automatically Fetched And Editable");
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "TG_3851_Verify_Field")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3851_Verify_Field");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}