package myfirstpackage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class secondpackage {
	public class php{
		WebDriver driver; 
		
		@BeforeMethod
		public void Open() {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium Learning\\chromedriver_win32 (2)\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
			driver.manage().window().maximize();
		}
		
			@Test(priority = 1)
			public void Women() throws InterruptedException {
			driver.findElement(By.linkText("Women"));
			driver.findElement(By.linkText("Tops")).click();;
			driver.findElement(By.linkText("T-shirts")).click();
			driver.findElement(By.name("layered_id_attribute_group_3")).click();
			driver.findElement(By.id("layered_id_attribute_group_14")).click();
			driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/div")).click();	
			Thread.sleep(2000);
			Actions action =new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div"))).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(3000);
			String products=driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span")).getText();	
				System.out.println("Total products: " +products);
				Thread.sleep(1000);
				String shipping=driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[2]/span")).getText();
				System.out.println("Total Shipping: " +shipping);
				Thread.sleep(1000);
				String Total=driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[3]/span")).getText();
				System.out.println("Total: " +Total);
				driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
				Thread.sleep(2000);
				String shortsleeve = driver.findElement(By.partialLinkText("Faded Short Sleeve T-shirts")).getText();
				System.out.println("sleeve: " +shortsleeve);
				String pproducts = driver.findElement(By.xpath("//*[@id='total_product']")).getText();
				assertEquals(products, pproducts);
				Thread.sleep(1000);
				String pshipping = driver.findElement(By.id("total_shipping")).getText();
				assertEquals(shipping,pshipping);
				String ptotal = driver.findElement(By.id("total_price")).getText();
				assertEquals(ptotal,Total);
				
		}
			
			//@Test(priority = 2)
		public void Store() {
				String expectedStoreMessage="Selenium Framework, Research Triangle Park, North Carolina, USA";
				WebElement storeElment=driver.findElement(By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[1]"));
				String storeMessage=storeElment.getText();
				assertEquals(storeMessage, expectedStoreMessage);
				
				
				
			}
		}
		
	}


