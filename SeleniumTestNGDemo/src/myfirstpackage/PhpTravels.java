package myfirstpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PhpTravels {
	WebDriver driver;
//WebDriverWait wait =new WebDriverWait(driver, 10);

	@BeforeMethod
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium Learning\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	//@Test(priority = 0)
	public void Login() throws InterruptedException {

		driver.findElements(By.xpath(("//input[@type='email']"))).get(0).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath(("//input[@type='password']"))).sendKeys("demouser");
		Thread.sleep(1000);
		driver.findElement(By.xpath(("//button[@type='submit']"))).click();
		Thread.sleep(5000);

	}

	//@Test(priority = 1)
	public void myProfile() throws InterruptedException {
		//Login();
		driver.findElement(By.linkText("MY PROFILE")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\'profilefrm\']/div/div/div[2]/div[1]/div/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'profilefrm\']/div/div/div[2]/div[1]/div/input"))
				.sendKeys("abc@gmail.com");
		driver.findElement(By.xpath(("//input[@type='password']"))).sendKeys("abcd");
		driver.findElement(By.name("confirmpassword")).sendKeys("abcd");
	}

	//@Test(priority = 2)
	public void SignUp() {
		driver.findElement(By.linkText("SIGN UP")).click();
	}

	//@Test(priority = 3)
	public void ForgetPassword() {
		driver.findElement(By.linkText("FORGET PASSWORD")).click();
	}

	@Test(priority = 4)
	public void Address1() throws InterruptedException {
		Login();
		myProfile();
		driver.findElement(By.name("address1")).clear();
		driver.findElement(By.name("address1")).sendKeys("101236-@abc");
		driver.findElement(By.name("address2")).sendKeys("789/A");
		driver.findElement(By.name("city")).sendKeys("hyd");
		driver.findElement(By.name("state")).sendKeys("telangana");
		driver.findElement(By.xpath("//*[@id='profilefr']/div/div/div[4]/div[2]/div/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div/div[4]/div[2]/div/div[2]/div/div/input")).sendKeys("India");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div/div[4]/div[2]/div/div[2]/div/div/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div/div[4]/div[2]/div/div[2]/div/div/input")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//input[type='text'])")).sendKeys("Albania");
		//driver.findElement(By.className("active-result result-selected")).click();
		//Select drpdn = new Select(driver.findElement(By.xpath("//*[@id='profilefrm']/div/div/div[4]/div[2]/div/div[2]/a")));
		//drpdn.selectByVisibleText("India");
		
	}

}