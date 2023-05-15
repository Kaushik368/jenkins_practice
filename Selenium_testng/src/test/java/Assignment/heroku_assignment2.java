package Assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class heroku_assignment2 {
	WebDriver driver;

	@BeforeTest
	public void Precondition(){
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 String url ="https://the-internet.herokuapp.com/";
		 driver.get(url);
		 driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
	}
	
	@Test(enabled = true)
	public void tc1() {
		driver.findElement(By.partialLinkText("Multiple Windows")).click();
		driver.findElement(By.partialLinkText("Click Here")).click();
		 Set <String> id =driver.getWindowHandles();
		 Iterator<String> it = id.iterator();
		 String parentid=it.next();

		 //navigate to child window
		String childid=it.next();

	
		driver.switchTo().window(parentid);
		driver.switchTo().window(childid);


		 System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		 
		 driver.switchTo().window(childid);
		 driver.switchTo().window(parentid);
		 System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}
	
	@Test(enabled = false)
	public void tc2() {
		
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}
	
	@Test(enabled = false)
	public void tc3() {
		driver.findElement(By.linkText("Drag and Drop")).click();
		WebElement A=driver.findElement(By.id("column-a"));
		WebElement B=driver.findElement(By.id("column-b"));
		Actions act=new Actions(driver);
		act.dragAndDrop(A, B).build().perform();
		
	}
	
	@Test(enabled = false)
	public void tc4() {
//		System.out.println(driver.findElement(By.tagName("ul")).getText());
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for(int i=1; i<ele.size(); i++) {
			String url1=ele.get(i).getAttribute("href");
			System.out.println(url1);
		}
		driver.findElement(By.linkText("Hovers")).click();
		
		String url_original = "https://the-internet.herokuapp.com/hovers";
		String url2 = driver.getCurrentUrl();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url2, url_original);
		soft.assertAll();
		
		
		Actions ac=new Actions(driver);
		WebElement ele1=driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
		ac.moveToElement(ele1).build().perform();

		driver.findElement(By.xpath("//a[contains(text(),'View profile')]")).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
}
}
