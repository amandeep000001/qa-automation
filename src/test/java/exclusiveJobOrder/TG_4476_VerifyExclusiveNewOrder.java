package exclusiveJobOrder;

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
import com.sf.pages.VerifyExclusiveNewOrderPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_4476_VerifyExclusiveNewOrder extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	Functions fun;
	VerifyExclusiveNewOrderPage newOrder;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4476_VerifyExclusiveNewOrder.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		newOrder = new VerifyExclusiveNewOrderPage (driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
	}
	@Test(dataProvider ="TG_VerifyExclusiveNewOrder")
	public void Tag_VerifySameJobOrderCreatedForParentStaffingCompany(String url, String username, String password) throws IOException, InterruptedException {
		test = extent.createTest("Verify New Order button On Homepage");
		log.info("Started==Verifying New Order button On Homepage");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login Successfully");
		test.log(Status.INFO,"Clicking on Order button");
		Thread.sleep(2000);
		newOrder.clickOrder();
		test.log(Status.PASS, "Click on Order button Successfully");
		test.log(Status.INFO,"Clicking on All Option button");
		Thread.sleep(3000);
		newOrder.selectAllOption();
		test.log(Status.PASS, "Click on All Option button Successfully");
		Thread.sleep(15000);
		Assert.assertEquals(newOrder.verifySameJobOrderCreatedForParentStaffingCompany(), true ,"  New Order button On Homepage not verify");
		test.log(Status.PASS, "Verifyied New Order button On Homepage Successfully");
	}
	
	@DataProvider(name = "TG_VerifyExclusiveNewOrder")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_VerifyExclusiveNewOrder"); // data tag from XML
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}