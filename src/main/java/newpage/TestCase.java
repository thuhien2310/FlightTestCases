package newpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.TimeUtils;

public class TestCase {
	private WebDriver driver = null;

	@Test(testName = "Testcase kiem tra ket qua tim kiem ve may bay tren trang Tripi.vn")
	public void testEasy() {
		driver.get("https://www.tripi.vn");

		// Click vao button khu hoi
		WebElement returnButton = driver.findElement(By.cssSelector("span.fw-item:nth-child(2)"));
		returnButton.click();

		// Nhap departure station"
		WebElement departureStation = driver.findElement(By.cssSelector("#flight-from-airport-value"));
		departureStation.sendKeys("HAN");
		TimeUtils.sleep(1);
		departureStation.sendKeys(Keys.RETURN);

		// Nhap arrival ..
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
			if ("15".equals(day.getText())) {
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
			if ("19".equals(day.getText())) {
				day.click();
				break;
			}
		}
		/// Change passengers
		WebElement passenger = driver.findElement(By.cssSelector(".ui-selectmenu-text"));
		passenger.click();
		WebElement adultNum = driver.findElement(By.cssSelector(
				".centered > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(5) > button:nth-child(1)"));
		adultNum.click();

		// Click tim kiem

		WebElement searchButton = driver.findElement(By.cssSelector(".flight-search-button"));
		searchButton.click();
		TimeUtils.sleep(5);

		// Check ket qua
		// Check outBoundTickets
		WebElement outBoundTicketsDiv = driver.findElement(By.cssSelector("#outBoundTickets"));
		List<WebElement> outboundTickets = outBoundTicketsDiv.findElements(By.cssSelector(".ticket-info"));
		int jetstarNum = 0;
		int vietjetNum =0;
		int vnairline =0;
		
		for (WebElement ticket : outboundTickets) {
			WebElement logo = ticket.findElement(By.cssSelector(".alogo"));
			String agency = logo.getAttribute("alt");
			if(agency.contains("Jetstar")) {
				jetstarNum++;
			}else if(agency.contains("VietJet")) {
				vietjetNum++;
			}else if(agency.contains("Vietnam")) {
				vnairline++;
			}
		}
		int numOfTickets = outboundTickets.size();
		// Check xem so luong xem > 0 ?
		Assert.assertEquals(numOfTickets > 0, true);
		Assert.assertEquals(vietjetNum > 0, true);
		Assert.assertEquals(vnairline > 0, true);
		Assert.assertEquals(jetstarNum > 0, true);
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
