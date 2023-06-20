package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class FavoriteStaffingCompany extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public FavoriteStaffingCompany(SelfHealingDriver driver, Logger log) throws IOException {
		super("FavoriteStaffingCompany.properties");
		obj = new ObjectRepository("FavoriteStaffingCompany.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickOrder() {
		log.info("Clicking on  Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("Orders"));
		element_Actions.findElement(obj.getElement("Orders"));
		element_Actions.click();
		log.info(" Order Button clicked successfully");
	}

	public void selectDirectOption() {
		log.info("Clicking on Direct Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("directOrders"));
		element_Actions.findElement(obj.getElement("directOrders"));
		element_Actions.click();
		log.info("Direct Order Button clicked successfully");
	}

	public boolean verifyStaffingCompanyList() {
		log.info("Verify Staffing Company List is displayed");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("staffCompanyListTitle"));
		Boolean display = element_Actions.findElement(obj.getElement("staffCompanyListTitle")).isDisplayed();
		log.info("Staffing Company List displayed successfully");
		return display;
	}

	public void markFavorite() {
		log.info("Marking as Favorite");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("heartIconNotLiked"));
		element_Actions.findElement(obj.getElement("heartIconNotLiked"));
		element_Actions.click();
		log.info("Marked successfully");
	}

	public void removeFavorite() {
		log.info("Removing from Favorites");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("heartIconLiked"));
		element_Actions.findElement(obj.getElement("heartIconLiked"));
		element_Actions.click();
		log.info("Removed from Favorites successfully");
	}

	public String verifyFavPopUpMessage() {
		log.info("Veify the pop up message");
		element_Actions.waitAndFindElement(obj.getElement("popUpMessageFav"));
		String PopUpMsg = element_Actions.findElement(obj.getElement("popUpMessageFav")).getText();
		log.info("Pop Up Message Verified");
		return PopUpMsg;
	}

	public void clickClosePopUp() {
		log.info("Verify Pop up closed sucessfully");
		element_Actions.waitAndFindElement(obj.getElement("closeButton"));
		element_Actions.click();
		log.info("Pop up closed sucessfully");
	}

}
