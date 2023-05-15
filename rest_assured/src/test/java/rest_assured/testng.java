package rest_assured;

import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
	@BeforeTest
	public void bt() {
		String Expected="Kaushik";
		String Actual="Biswas";
		Assert.assertEquals( Expected, Actual);
	}
	@Test
	public void tc1() {
		System.out.println("I am getting trained in API testing");
	}
	
	@AfterTest
	public void af() {
		System.out.println("I am very good");
	}
}
