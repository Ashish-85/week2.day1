package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("democsr");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Harry");
		Thread.sleep(2000);
		String attribute = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Rogger");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Harry Local");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Walmart");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a good departmental Store");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ashish_testleaf@gmail.com");

		WebElement findElement1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select s = new Select(findElement1);
		Thread.sleep(2000);
		s.selectByValue("AK");

		driver.findElement(By.name("submitButton")).click();

		String title = driver.getTitle();
		System.out.println(title);

		driver.close();

	}

}
