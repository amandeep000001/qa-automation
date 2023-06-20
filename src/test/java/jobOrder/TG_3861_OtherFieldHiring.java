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
import com.sf.pages.OtherFieldHiringPage;
import com.sf.pages.StartDateTimeFieldPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3861_OtherFieldHiring extends TestBase  {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	OtherFieldHiringPage  otherField;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3861_OtherFieldHiring.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		otherField = new  OtherFieldHiringPage (driver,log); 
	}
	@Test(dataProvider ="TG_3861_Other_Field_Hiring_page")
	public void Tag_VerifyNoOfWorkersField(String url ,String username,String password, String eSignName) throws InterruptedException {
		test = extent.createTest("Verify No Of Workers Field");
		log.info("Started==_Verifying No Of Workers Field");  
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successfully");
		test.log(Status.INFO, "Clicking New order button ");
		otherField.newOrder();
		test.log(Status.PASS, "New order button click successfully");
		Assert.assertEquals(otherField.verifyNoOfWorkersField(),true , "Verify No Of Workers Field Not Visible");
		test.log(Status.PASS, "Verify No Of Workers Field Visible");
		Thread.sleep(3000);
	
		log.info("Started==Verify E-Signature Field Should Mandatory");  
		otherField.newOrder();
		Assert.assertEquals(otherField.verifyESignatureFieldMandatory(),true , "Verify E-Signature Field Should Mandatory");
		test.log(Status.PASS, "Verify E-Signature Field Should Mandatory");
		Thread.sleep(3000);
	
		log.info("Started==Verifying Agree Contract Field should be checkbox And Mandatory");  
		otherField.enterESignatureName(eSignName);
		otherField.newOrder();
		Assert.assertEquals(otherField.verifyAgreeContractFieldshouldcheckboxAndMandatory(),true , "Verify Agree Contract Field should be checkbox And Mandatory");
		test.log(Status.PASS, "Verify Agree Contract Field should be checkbox And Mandatory");
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "TG_3861_Other_Field_Hiring_page")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3861_Other_Field_Hiring_page");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}