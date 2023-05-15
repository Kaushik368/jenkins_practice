package Assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class project_practice {
	WebDriver driver;

	@BeforeTest
	public void Precondition(){
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String url ="https://karnatakatourism.org/";
		 driver.get(url);
		 
	}
	@AfterMethod
	public void msg() {
		System.out.println("--------------------Test Automated Successfully--------------------");
	}
	@Test()
	public void tc1() {
		System.out.println(driver.findElement(By.xpath("(//span[@class='item_text'])[30]")).getText());
//		driver.findElement(By.partialLinkText("Click Here")).click();
		
		
//		Set <String> id =driver.getWindowHandles();
//		 Iterator<String> it = id.iterator();
//		 String parentid=it.next();
//
//		 //navigate to child window
//		String childid=it.next();
//
//	
//		driver.switchTo().window(parentid);
//		driver.switchTo().window(childid);
//
//
//		 System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
//		 
//		 driver.switchTo().window(childid);
//		 driver.switchTo().window(parentid);
//		 System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}
	@Test()
	public void tc2() {
		Actions ac=new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("(//span[@class='item_text'])[30]"));
		ac.moveToElement(ele).build().perform();
		System.out.println(driver.findElement(By.cssSelector("#nav-menu-item-122711 > a > span > span")).getText());
	}
	@Test
	public void tc3() {
		Actions ac=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("(//span[@class='item_text'])[30]"));
		ac.moveToElement(ele).build().perform();
		System.out.println(driver.findElement(By.cssSelector("#nav-menu-item-127108 > a > span > span")).getText());
	}
	
	
}
