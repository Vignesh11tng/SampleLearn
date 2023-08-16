package org.logoff;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitionClass extends BaseClass{
	
	AdactinHomePage adact;
	SearchHotel search;
	SelectHotel select;
	BookHotel book;
	OrderNo order;
	
	@Given("User should navigate to Adactin Home Page")
	public void user_should_navigate_to_adactin_home_page() {
	    browserLaunch("http://adactinhotelapp.com/index.php");
	}
	
	@When("User enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		adact = new AdactinHomePage();
		WebElement txtUsername = adact.getTxtUsername();
		WebElement txtPassword = adact.getTxtPassword();
		enterText(txtUsername, string);
		enterText(txtPassword, string2);
	}

	@When("User clicks the login buttion")
	public void user_clicks_the_login_buttion() {
		WebElement btnLogin = adact.getBtnLogin();
		click(btnLogin);
	}
//	@Then("Validate the login status")
//	public void validate_the_login_status() {
//	    WebElement errmsg = adact.getErrmsg();
//	    String string = get(errmsg, "getText");
//	    Assert.assertEquals(false, string.contains("Invalid"));
//	    System.out.println("Login successfully");
//	}
	
	@When("User enter location, Hotels, Room Type, NumberOfRooms, DateIn, DateOut, AdultsPerRoom, ChildrenPerRoom")
	public void user_enter_location_hotels_room_type_number_of_rooms_date_in_date_out_adults_per_room_children_per_room() {
		search = new SearchHotel();
		WebElement selectLocation = search.getSelecttLocation();
		selectByMethod("selectByValue",selectLocation,"Sydney");
		WebElement selectHotels = search.getSelectHotels();
		selectByMethod("selectByValue",selectHotels,"Hotel Creek");
		WebElement selectRoomType = search.getSelectRoomType();
		selectByMethod("selectByValue",selectRoomType,"Standard");
		WebElement selectRoomNos = search.getSelectRoomNos();
		selectByMethod("selectByValue",selectRoomNos,"2");
		WebElement datepickIn = search.getDatepickIn();
		enterText(datepickIn,"09/05/2023");
		WebElement datepickOut = search.getDatepickOut();
		enterText(datepickOut,"10/05/2023");
		WebElement adultRoom = search.getAdultRoom();
		selectByMethod("selectByValue",adultRoom,"2");
		WebElement childRoom = search.getChildRoom();
		selectByMethod("selectByValue",childRoom,"2");
	}
	@When("User clicks the Search buttion")
	public void user_clicks_the_search_buttion() {
		search = new SearchHotel();
		WebElement submit = search.getSubmit();
		click(submit);
	}
	
	@When("User should select desired hotel")
	public void user_should_select_desired_hotel() {
		select = new SelectHotel();
		WebElement radioButton = select.getRadioButton();
		click(radioButton);
	}
	@When("User clicks the Continue buttion")
	public void user_clicks_the_continue_buttion() {
		select = new SelectHotel();
		WebElement continueBtn = select.getContinueBtn();
		click(continueBtn);
	}
	@When("User enter FirstName, LastName, BillingAddress, CreditCardNo, CreditCardType, ExpiryMonth, ExpiryYear, CVVNumber")
	public void user_enter_first_name_last_name_billing_address_credit_card_no_credit_card_type_expiry_month_expiry_year_cvv_number() {
		book = new BookHotel();
		WebElement firstName = book.getFirstName();
		enterText(firstName,"Vignesh");
		WebElement lastName = book.getLastName();
		enterText(lastName,"Nithiyan");
		WebElement address = book.getAddress();
		enterText(address,"OMR, Perugudi, Chennai");
		WebElement ccNum = book.getCcNum();
		enterText(ccNum,"1234567890123456");
		WebElement ccType = book.getCcType();
		selectByMethod("selectByValue",ccType,"VISA");
		WebElement ccExpMonth = book.getCcExpMonth();
		selectByMethod("selectByValue",ccExpMonth,"2");
		WebElement ccExpYear = book.getCcExpYear();
		selectByMethod("selectByValue",ccExpYear,"2018");
		WebElement ccCvv = book.getCcCvv();
		enterText(ccCvv,"456");
	}
	@When("User clicks the BookNow button")
	public void user_clicks_the_book_now_button() {
		book = new BookHotel();
		WebElement bookNow = book.getBookNow();
		click(bookNow);
	}
	
	@Then("Validate Order Number Generated or not")
	public void validate_order_number_generated_or_not() throws InterruptedException, IOException {
		Thread.sleep(12000);
		order = new OrderNo();
		WebElement orderNo = order.getOrderNo();
		String value = orderNo.getAttribute("value");
		System.out.println(value);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("C:\\Users\\HP\\eclipse-workspace\\CucumberClass\\src\\test\\resources\\Cucumber.png"));
	
	}
}
