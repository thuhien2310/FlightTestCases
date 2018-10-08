package newpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import utils.TimeUtils;

public class FlightBooking {
	private WebDriver driver = null;			
	
	@Test(testName = "Testcase kiem tra viec book ve co dien ra binh thuong")			
	public void testEasy() {			
		driver.get("https://www.tripi.vn");						
		TimeUtils.sleep(5);		
		
		// Click vao button khu hoi		
		WebElement returnButton = driver.findElement(By.cssSelector("span.fw-item:nth-child(2)"));			
		returnButton.click();		
				
		// Nhap departure station	
		WebElement departureStation = driver.findElement(By.cssSelector("#flight-from-airport-value"));		
		departureStation.sendKeys("HAN");		
		TimeUtils.sleep(1);		
		departureStation.sendKeys(Keys.RETURN);		
				
		// Nhap arrival station		
		WebElement arrivalStation = driver.findElement(By.cssSelector("#flight-to-airport-value"));		
		arrivalStation.sendKeys("SGN");		
		TimeUtils.sleep(1);		
		arrivalStation.sendKeys(Keys.RETURN);		
				
		// Nhap departure date		
		WebElement checkinDate = driver.findElement(By.cssSelector("#flight-checkin-date"));		
		checkinDate.click();					
		WebElement tableCheckinDate = checkinDate.findElement(By.xpath(".."));		
		List<WebElement> days = tableCheckinDate.findElements(By.tagName("td"));		
		for (WebElement day : days) {
			if ("22".equals(day.getText())) {
				day.click();
				break;
			}
		}		
				
		// Nhap ngay ve		
		WebElement checkoutDate = driver.findElement(By.cssSelector("#flight-checkout-date"));		
		checkoutDate.click();		
		WebElement tableCheckoutDate = checkoutDate.findElement(By.xpath(".."));		
		List<WebElement> checkoutDays = tableCheckoutDate.findElements(By.tagName("td"));		
		for (WebElement day : checkoutDays) {
			if ("25".equals(day.getText())) {
				day.click();
				break;
			}
		}		
		/// Change passengers		
		WebElement passenger = driver.findElement(By.cssSelector(".ui-selectmenu-text"));		
		passenger.click();		
		WebElement adultNum = driver.findElement(By.cssSelector(".centered > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(5) > button:nth-child(1)"));				
		adultNum.click();		
				
		// Click tim kiem		
				
		WebElement searchButton = driver.findElement(By.cssSelector(".flight-search-button"));		
		searchButton.click();		
		TimeUtils.sleep(7);		
				
		//Chon ve chieu di		
		WebElement outBoundTicketsDiv = driver.findElement(By.cssSelector("#outBoundTickets"));		
		List<WebElement> outboundTickets = outBoundTicketsDiv.findElements(By.cssSelector(".ticket-info"));		
		System.out.println("Chon ve chieu di:");		
		for (WebElement ticket : outboundTickets) {		
			WebElement logo = ticket.findElement(By.cssSelector(".alogo"));	
			String agency = logo.getAttribute("alt");	
				
			if (agency.contains("Jetstar")) {				
				WebElement selectBtnob = ticket.findElement(By.cssSelector(".flight-select-single-ticket"));
				selectBtnob.click();
				TimeUtils.sleep(2);
				System.out.println(agency);
				break;
			}	
			}	
		//Chon ve chieu ve		
		WebElement inBoundTicketstab = driver.findElement(By.cssSelector("div.menu-item:nth-child(3)"));		
		inBoundTicketstab.click();					
		TimeUtils.sleep(5);						
		WebElement inBoundTicketsDiv = driver.findElement(By.cssSelector("#inboundTickets.tickets"));		
		List<WebElement> inboundTickets = inBoundTicketsDiv.findElements(By.cssSelector(".ticket-info"));		
				
		System.out.println("Chon ve chieu ve:");		
		for (WebElement ticketib : inboundTickets) {		
				
			WebElement logoib = ticketib.findElement(By.cssSelector(".alogo"));	
			String agencyib = logoib.getAttribute("alt");	
				
			if (agencyib.contains("VietJet")) {	
				WebElement selectBtnib = ticketib.findElement(By.cssSelector(".flight-select-return-ticket"));
				selectBtnib.click();
				TimeUtils.sleep(2);
				System.out.println(agencyib);
				break;
				
			}	
		}		
		//Xac nhan chon ve		
		WebElement selectedFlightDiv = driver.findElement(By.cssSelector("#selected-flight"));		
		WebElement confirmBookTicketbtn = selectedFlightDiv.findElement(By.cssSelector(".flight-search-booking-ticket"));		
		confirmBookTicketbtn.click();		
		TimeUtils.sleep(5);		
				
		//Nhap tt hanh khach thu nhat			
		WebElement firstGuestDiv = driver.findElement(By.cssSelector("#adult-0"));	
		//Nhap lastname	
		WebElement lastNametext = firstGuestDiv.findElement(By.cssSelector(".form-control.last-name"));
		lastNametext.clear();
		lastNametext.sendKeys("Nguyen");	
		//Nhap firstname				
		WebElement firstNametext = firstGuestDiv.findElement(By.cssSelector(".form-control.first-name"));
		firstNametext.clear();
		firstNametext.sendKeys("Van An")	;
		//Chon gioi tinh	
		WebElement genderOfFirstGuestDiv = firstGuestDiv.findElement(By.cssSelector(".form-control.gender"));	
		Select dropdown= new Select(genderOfFirstGuestDiv);	
		dropdown.selectByVisibleText("Nam");	
		TimeUtils.sleep(3);				
				
		//Nhap tt hanh khach thu hai	
		
				WebElement secondGuestDiv = driver.findElement(By.cssSelector("#adult-1"));	
				//Nhap lastname	
				WebElement lastNametext2 = secondGuestDiv.findElement(By.cssSelector(".form-control.last-name"));	
				lastNametext2.clear();
				lastNametext2.sendKeys("Nguyen");	
				//Nhap firstname						
				WebElement firstNametext2 = secondGuestDiv.findElement(By.cssSelector(".form-control.first-name"));	
				firstNametext2.clear();
				firstNametext2.sendKeys("Hong Ha")	;
				//Chon gioi tinh	
				WebElement genderOfFirstGuestDiv2 = secondGuestDiv.findElement(By.cssSelector(".form-control.gender"));	
				Select dropdown2= new Select(genderOfFirstGuestDiv2);	
				dropdown2.selectByVisibleText("Nữ");
				TimeUtils.sleep(5);			
		
				//Chon mua them hanh ly
				//The chon hanh ly
				WebElement baggagesDiv = driver.findElement(By.cssSelector(".row"));
				//chon hanh ly hanh khach thu nhat - chon goi 15kg
				WebElement baggagesNum = baggagesDiv.findElement(By.cssSelector(".form-control.baggage"));
				Select dropdown3= new Select(baggagesNum);	
				dropdown3.selectByVisibleText("Gói (Bag) 15 kg - 160.000đ");	
				TimeUtils.sleep(5);		
				
				//Nhap thong tin lien he
				//tim the thong tin lien he
				WebElement contactDiv = driver.findElement(By.cssSelector("#contact-info"));				
				//Chon gioi tinh
				WebElement contactGender = contactDiv.findElement(By.cssSelector("#ticket-booking-select-title"));
				Select dropdown4= new Select(contactGender);	
				dropdown4.selectByVisibleText("Bà");	
								
				//Nhap Ho
				WebElement lastNametext3 = contactDiv.findElement(By.cssSelector(".form-control.last-name"));	
				lastNametext3.clear();
				lastNametext3.sendKeys("Nguyen");	
				//Nhap Ten
				WebElement firstNametext3 = contactDiv.findElement(By.cssSelector(".form-control.first-name"));	
				firstNametext3.clear();
				firstNametext3.sendKeys("Van An")	;
				//Nhap email
				WebElement emailContact = contactDiv.findElement(By.cssSelector(".form-control.email"));	
				emailContact.clear();
				emailContact.sendKeys("test@gmail.com")	;
				//Nhap so dien thoai
				WebElement phoneContact = contactDiv.findElement(By.cssSelector(".form-control.phone1"));	
				phoneContact.clear();
				phoneContact.sendKeys("0986111111")	;
				//Chon phuong thuc thanh toan
				//Tim the pttt
				TimeUtils.sleep(2);	
				WebElement paymentMethodDiv = driver.findElement(By.cssSelector(".row"));
				//WebElement paymentVisa = paymentMethodDiv.findElement(By.cssSelector("#payment-method-1"));
				WebElement paymentVisa = paymentMethodDiv.findElement(By.cssSelector("#payment-method-1"));
				paymentVisa.click();
				// click nut thanh toan
				WebElement paymentButton = driver.findElement(By.cssSelector(".flight-initiate-checkout"));
				paymentButton.click();				
				TimeUtils.sleep(5);		
				
				//an nut Xac nhan dong y thanh toan
				WebElement confirmBtnDiv = driver.findElement(By.cssSelector(".modal-footer"));
				WebElement confirmBtn = confirmBtnDiv.findElement(By.cssSelector(".modal-footer > button:nth-child(2)"));
				confirmBtn.click();
				TimeUtils.sleep(40);		
				//kiem tra cong thanh toan da chon
				WebElement gatewayDiv = driver.findElement(By.cssSelector("#gateway"));
				//kiem tra radio button duoc checked
				WebElement radioBtnDiv = gatewayDiv.findElement(By.tagName("td"));
				WebElement radioBtn = radioBtnDiv.findElement(By.cssSelector(".copy_radio"));
				Assert.assertEquals(radioBtn.isSelected(),true);
				WebElement methodLabel = radioBtnDiv.findElement(By.cssSelector(".copy"));
				Assert.assertEquals(methodLabel.getText(),"Thẻ quốc tế");
				TimeUtils.sleep(5);	
		}		
				
@BeforeTest				
public void beforeTest() throws Exception {				
	driver = new FirefoxDriver();		
	driver.manage().window().maximize() ;
}				
				
@AfterTest				
public void afterTest() {				
	driver.quit();			
}				
	
}
