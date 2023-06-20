package favoriteCompany;

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
import com.sf.pages.FavoriteStaffingCompany;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_4778_FavoriteStaffingCompany extends TestBase {

	LoginPage jo;
	// JobOrderPage order;
	Functions functions;
	HomePage homePage;
	Functions fun;
	String JobOrderId;
	FavoriteStaffingCompany fav;
	BlockCompany block;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4778_FavoriteStaffingCompany.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		block = new BlockCompany(driver, log);
		fun = new Functions();
		fav = new FavoriteStaffingCompany(driver, log);
	}

	@Test(dataProvider = "TG_4778_FavoriteStaffingCompany")
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
		Assert.assertEquals(fav.verifyStaffingCompanyList(), true, " unable to Verify Staffing Companies");
		test.log(Status.PASS, "Verified Staffing Company List Successfully");
	
		
		test.log(Status.INFO,"Clicking on Distance Filter");
		block.clickDistanceFilter();
		test.log(Status.PASS,"Clicked on Distance Filter");
		Thread.sleep(3000);
		
		test.log(Status.INFO,"Clicking on Clear Filter");
		block.clickClearFilter();
		test.log(Status.PASS,"Clicked on Clear Filter");
		Thread.sleep(3000);
		
		log.info("Clicking Heart Icon");
		Thread.sleep(5000);
		fav.markFavorite();
		test.log(Status.PASS, "Heart Icon Clicked successfully");
	
		log.info("Verifying Company Marked as Favorite");
		
		Assert.assertEquals(fav.verifyFavPopUpMessage().contains("has been added to favorites."), true,
				"'Company is not added to Favorites");
		test.log(Status.PASS, "Verified Staffing Company List Successfully");
		Thread.sleep(3000);
		fav.clickClosePopUp();
		Thread.sleep(4000);
	
		log.info("Removing from Favorites");
		Thread.sleep(4000);
		fav.removeFavorite();
		test.log(Status.PASS, "Removed from Favorites Successfully");
		Thread.sleep(4000);
		fav.clickClosePopUp();
	}

	@DataProvider(name = "TG_4778_FavoriteStaffingCompany")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_4778_FavoriteStaffingCompany"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();

	}

}