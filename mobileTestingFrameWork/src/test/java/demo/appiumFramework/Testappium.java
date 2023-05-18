package demo.appiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.TapOptions;

public class Testappium extends capability{

	
		AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void setup() throws IOException, InterruptedException {
			startAppium().start();
			driver = hybridCapability();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
//		
		
		@Test
		public void test5() throws InterruptedException, IOException{
//			startAppium().start();
//			driver = hybridCapability();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kaushik Biswas");
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			AndroidElement ele=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Send me e-mails on discounts related to selected products in future\")"));
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(ele))).perform();
			

			AndroidElement ele1=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			tact.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).release().perform();
			
			AndroidElement ele2=driver.findElement(By.id("android:id/button1"));
			tact.tap(TapOptions.tapOptions().withElement(element(ele2))).perform();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			Thread.sleep(10000);
//			if you are testing an app which has both native and web
//			if you want to understand you are in the context of web and how to shift to native then you use the below code
			Set<String> contextnames=driver.getContextHandles();
			for(String contextname:contextnames) {
//				if it is showing both native and web it is a hybrid app
//				else it's only native
				
				System.out.println(contextname);
			}
//			below code is switching to web app
			driver.context("WEBVIEW_com.androidsample.generalstore");
			 boolean title=driver .getTitle().contains("Google");
			 Assert.assertTrue(title);
			 driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Masai",Keys.ENTER);
			 driver.context("NATIVE_APP");
			 driver.pressKey(new KeyEvent(AndroidKey.BACK));
			 Thread.sleep(3000);
			 
			 startAppium().stop();
		}

	}


