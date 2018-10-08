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

import utils.TimeUtils;

public class SearchHotel {
	private WebDriver driver = null;

	@Test(testName = "Testcase kiem tra ket qua tim kiem khach san tren trang Tripi.vn")
	public void testEasy() {
		driver.get("https://www.tripi.vn");

		TimeUtils.sleep(5);
		// Chon tab hotel
		WebElement hotelTab = driver.findElement(By.cssSelector(".sfm-item:nth-child(3)"));
		hotelTab.click();
		TimeUtils.sleep(2);
		// Chon diem den
		WebElement arrivalPoint = driver.findElement(By.cssSelector("#hotel-autocomplete-input-value"));
		arrivalPoint.click();
		arrivalPoint.sendKeys("Hà Nội");
		TimeUtils.sleep(2);
		arrivalPoint.sendKeys(Keys.RETURN);
		
		//Chon ngay di
		WebElement checkinDateField = driver.findElement(By.cssSelector("#hotel-check-in-value"));
		checkinDateField.click();
		WebElement checkinDateDiv	= driver.findElement(By.cssSelector(".month-wrapper"));
		WebElement checkinDate = checkinDateDiv.findElement(By.cssSelector(".month1"));
	
		//WebElement tableCheckinDate = checkinDate.findElement(By.xpath(".."));
		List<WebElement> days = checkinDate.findElements(By.tagName("td"));
		for (WebElement day : days)
		{
			if ("22".equals(day.getText()))
			{
				day.click();
				System.out.println("Chon ngay den:");	
				break;
			}
		}	
		for (WebElement dayOut : days) 
		{
			 if ("25".equals(dayOut.getText()))
			 {
				System.out.println("Chon ngay di:");	
				dayOut.click();
				break;
			}
		}
		TimeUtils.sleep(5);
		
		/// Change passengers
				WebElement roomDiv = driver.findElement(By.cssSelector(".ui-selectmenu-button"));
				roomDiv.click();
				WebElement roomNum = driver.findElement(By.cssSelector(".centered > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(5) > button:nth-child(1)"));
				roomNum.click();

				// Click tim kiem

				WebElement searchButton = driver.findElement(By.cssSelector(".hotel-search-button"));
				searchButton.click();				
				TimeUtils.sleep(5);
								 
				// Kiem tra so luong ket qua khach san tra ve
					
				WebElement searchItemsDiv = driver.findElement(By.cssSelector(".result-items"));
				List<WebElement> searchItems = searchItemsDiv.findElements(By.cssSelector(".item-wrapper"));				
				int hotelNum = 0;
				System.out.println("Danh sach khach san:");
				for (WebElement item : searchItems) 
				{
					WebElement itemName = item.findElement(By.cssSelector(".item-name"));
					String titleHotel = itemName.getAttribute("title");			
					System.out.println(titleHotel);
					if (titleHotel.contains(" ")) 
					{
						hotelNum++;
			     	}
		
				}
				System.out.println("So luong khach san tra ve:"+hotelNum);
				Assert.assertEquals(hotelNum > 0, true);
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