package login;

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
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.Log;
import com.sf.utility.XmlReader;

public class LoginHiring extends TestBase {

	LoginPage lp;
	Functions functions;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(LoginHiring.class.getName());
		functions = new Functions();
		lp = new LoginPage(driver, log);
	}

	@Test(dataProvider = "TG_234_Login")
	public void TG_234_LoginApplication(String url, String username, String password)throws IOException, InterruptedException {
		test = extent.createTest("TG_234 Login Functionality");
		log.info("Started==TAG Login Functionality");
		driver.get(url);
		log.info("Logging into the application using username: " + username);
		test.log(Status.INFO, "Logging into the application using username: " + username);		
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();
		Assert.assertEquals(lp.checkLoginSuccessfully(), true, "User unable to login");
		log.info("User: " + username + " logged in successfully");
		test.log(Status.PASS, "User " + username + " logged in successfully");
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