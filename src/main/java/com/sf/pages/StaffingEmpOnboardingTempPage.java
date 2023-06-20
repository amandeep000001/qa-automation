package com.sf.pages;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class StaffingEmpOnboardingTempPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	
	public StaffingEmpOnboardingTempPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("StaffingEmpOnboardingTempPage.properties");
		obj = new ObjectRepository("StaffingEmpOnboardingTempPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	
	public boolean verifyEmployeeOnboardingTemplateTitle() 
	{
		log.info("Verify EmployeeOnboardingTemplateTitle on the employee-onboarding Template page");
		element_Actions.waitAndFindElement(obj.getElement("employeeOnboardingTemplateTitle"));
		boolean display=element_Actions.findElement(obj.getElement("employeeOnboardingTemplateTitle")).isDisplayed();;
		log.info("EmployeeOnboardingTemplateTitle menu displayed successfully");
		return display;
	}
	public void clickAddEmployeeOnboardingTemplate() 
	{
		log.info("Clicking AddEmployeeOnboarding present on the  employee-onboarding page");
		element_Actions.waitAndFindElement(obj.getElement("addEmployeeOnboardingTemplateButton"));
//		element_Actions.findElement(obj.getElement("addEmployeeOnboardingTemplateButton"));
		element_Actions.click();
		log.info("Add Employee Onboarding button clicked successfully.");
	}
	public boolean verifyNewEmployeeOnboardingTemplateTitle() 
	{
		log.info("Verify New Employee Onboarding Template Title while clicking add Employee Onboarding Template Button");
		element_Actions.waitAndFindElement(obj.getElement("newEmployeeOnboardingTemplateTitle"));
		boolean display=element_Actions.findElement(obj.getElement("newEmployeeOnboardingTemplateTitle")).isDisplayed();
		log.info("New Employee Onboarding Template Title displayed while clicking add Employee Onboarding Template Button successfully");
		return display;
	}
	public String verifyCompanyFeildMandatory() 
	{
		log.info("Verify Company field mandatory and auto-populate");
		element_Actions.waitAndFindElement(obj.getElement("companyFeild"));
		String message = element_Actions.findElement(obj.getElement("companyFeild")).getText();
		log.info("Verified Company field mandatory and auto-populated successfully");
		return message;
	}
	public boolean verifyCompanyFeildAutoPopulated() 
	{
		log.info("Verify Company Feild auto populated in new Employee Onboarding Template");
		element_Actions.waitAndFindElement(obj.getElement("companyFeildAutoPopulate"));
		boolean display=element_Actions.findElement(obj.getElement("companyFeildAutoPopulate")).isDisplayed();
		log.info("Company Feild auto populated in new Employee Onboarding Template successfully.");
		return display;
	}
	public void clickAddRowButton() 
	{
		log.info("Clicking Add Row button on the form under the Activities Panel");
		element_Actions.waitAndFindElement(obj.getElement("addRowButton"));
		element_Actions.findElement(obj.getElement("addRowButton"));
		element_Actions.click();
		log.info("Clicked Add Row button on the form under the Activities Panel successfully");
	}
	public void clickEditButton() 
	{
		log.info("Clicking edit button on the form under the Activities Panel");
		element_Actions.waitAndFindElement(obj.getElement("editButton"));
		element_Actions.findElement(obj.getElement("editButton"));
		element_Actions.click();
		log.info("Clicked edit button on the form under the Activities Panel successfully");
	}
	public boolean verifyEditModal() 
	{
		log.info("Verify new Modal should open on clicking edit button");
		element_Actions.waitAndFindElement(obj.getElement("editModal"));
		boolean display = element_Actions.findElement(obj.getElement("editModal")).isDisplayed();
		log.info("new Modal opened on clicking edit button successfully.");
		return display;
	}
	public boolean verifyActivityNameModal() 
	{
		log.info("Checking Activity name is Visible in modal");
		element_Actions.waitAndFindElement(obj.getElement("modalActivityName"));
		boolean display=element_Actions.findElement(obj.getElement("modalActivityName")).isDisplayed();
		log.info("Activity name is Visible in modal displayed successfully");
		return display;
	}
	public void clickDropModalClose() 
	{
		log.info("Clicking Dropdown arrow in the modal");
		element_Actions.waitAndFindElement(obj.getElement("dropDownModal"));
		element_Actions.findElement(obj.getElement("dropDownModal"));
		element_Actions.click();
		log.info("Clicked Dropdown arrow in the modal successfully");
	}
	public void clickSaveButton() throws InterruptedException 
	{
		log.info("Clicking save button on the form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
	    element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
	    Thread.sleep(2000);
		log.info("Clicked save button on the form successfully");
	}
	public String verifyMissingFieldPopUp() 
	{
		log.info("Verify Missing field dialog while clicking save Button");
		element_Actions.waitAndFindElement(obj.getElement("missingFieldPopUp"));
		String message = element_Actions.findElement(obj.getElement("missingFieldPopUp")).getText();
		log.info("Missing field dialog displayed while clicking save Button successfully.");
		return message;
	}
	 public void enterActivityName(String activityname)
	{
		log.info("Entering Activity name");
		element_Actions.waitAndFindElement(obj.getElement("activityNameFeild"));
		element_Actions.findElement(obj.getElement("activityNameFeild"));
		element_Actions.sendKeys(activityname);
		log.info("Activity name entered successfully");
	}
	 public boolean verifyUserVisible() 
    {
		log.info("Checking user is Visible");
		element_Actions.waitAndFindElement(obj.getElement("userField"));
		boolean display=element_Actions.findElement(obj.getElement("userField")).isDisplayed();
		log.info("Employee Onboarding Template is displayed successfully");
		return display;
	}
	 public void enterUserFeildValue(String userfeild) throws InterruptedException
	{
		log.info("Entering user field value ");
		element_Actions.waitAndFindElement(obj.getElement("userField"));
		element_Actions.findElement(obj.getElement("userField"));
		element_Actions.sendKeys(userfeild);
		element_Actions.click();
		element_Actions.waitAndFindElement(obj.getElement("modalActivityName"));
		element_Actions.click();
		Thread.sleep(2000);
        log.info("entered successfully");
	}
	 public boolean verifyDocumentRequiredVisible() 
    {
		log.info("Checking Document Required is Visible");
		element_Actions.waitAndFindElement(obj.getElement("documentRequired"));
		boolean display=element_Actions.findElement(obj.getElement("documentRequired")).isDisplayed();
		log.info("Document Required is displayed successfully");
		return display;
	}
	 public void clickCheckBoxDocumentRequired() throws InterruptedException 
	{
		log.info("Clicking CheckBox DocumentRequired in modal");
		element_Actions.waitAndFindElement(obj.getElement("checkBoxDocumentRequired"));
		element_Actions.findElement(obj.getElement("checkBoxDocumentRequired"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("CheckBox clicked in modal successfully");
	}
	 public void enterDocument(String document)
    {
		log.info("Clicking Document dropdown in modal");
		element_Actions.waitAndFindElement(obj.getElement("dropDownDocument"));
		element_Actions.findElement(obj.getElement("dropDownDocument"));
		element_Actions.sendKeys(document);
		Select select = new Select(element_Actions.findElement(obj.getElement("dropDownDocument")));
		select.selectByVisibleText("W4");
		log.info("Document dropdown in modal clicked successfully");
	}
	public boolean verifyAttachment() 
	{
		log.info("Verify attachment auto populated on selecting dropdown value");
		element_Actions.waitAndFindElement(obj.getElement("attachment"));
		boolean display=element_Actions.findElement(obj.getElement("attachment")).isDisplayed();
		log.info("Attachment auto populated on selecting dropdown valuesuccessfully.");
		return display;
	}
	public void clickAttachButton() 
	{
		log.info("Clicking attach button in modal");
		element_Actions.waitAndFindElement(obj.getElement("attachButton"));
		element_Actions.findElement(obj.getElement("attachButton"));
		element_Actions.click();
		log.info("Attach Button clicked in modal successfully");
	}
	public void enterMyDevice(String pdf) throws InterruptedException
	{
		log.info("Attaching a pdf file in the attachment");
		Thread.sleep(5000);
		File file = new File(pdf);
        element_Actions.findElement(obj.getElement("myDeviceButton"));
	    Thread.sleep(2000);
		System.out.println(file.getAbsolutePath());
		element_Actions.sendKeys(file.getAbsolutePath());
		log.info("Attached a pdf file in the attachment successfully");
	}
	public void clickUploadButton() 
	{
		log.info("Clicking Upload button in modal");
		element_Actions.waitAndFindElement(obj.getElement("uploadButton"));
		element_Actions.findElement(obj.getElement("uploadButton"));
		element_Actions.click();
		log.info("Upload Button clicked inmodal successfully");
	}
	public String verifyNewEntry() throws InterruptedException 
	{
		log.info("Verify new entry created after clicking save Button");
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("newEntry"));
		Thread.sleep(3000);
	    String message = element_Actions.findElement(obj.getElement("newEntry")).getText();
		Thread.sleep(2000);
		log.info("New entry created after clicking save Button successfully.");
		return message;
	}
	public void clickCloseIcon() throws InterruptedException {
		log.info("Clicking on Close Icon");
		element_Actions.waitAndFindElement(obj.getElement("modalCloseIcon"));
		element_Actions.findElement(obj.getElement("modalCloseIcon"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Close Icon clicked successfully");
	}
	public void enterTemplateName(String templateName)
	{
		log.info("Entering TemplateName ");
		element_Actions.waitAndFindElement(obj.getElement("templateNameFeild"));
		element_Actions.findElement(obj.getElement("templateNameFeild"));
		element_Actions.sendKeys(templateName);
		log.info("TemplateName entered successfully");
	}
}
	 


	 
	 
	 
	 

