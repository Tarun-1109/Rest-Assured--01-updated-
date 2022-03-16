package RestTesting;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
public class TestNg {
	
	//Method
	//TestSuite//Collection of TestCases
	@BeforeSuite
	public void BS()
	{
		System.out.println("It will exceute first");
	}
	
	//If i have many tests and if i want to execute any pre-requite before i can use before test
	@BeforeTest
	public void BT()
	{
		System.out.println("It will execute after BeforeSuite");
	}
	
	@BeforeClass
	public void BC()
	{
		System.out.println("It will exceute before the class get executed ");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("It will execute before every Test Method");
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("It is first test Method");
	}
	
	@Test
	public void testcase2()
	{
		System.out.println("It is first test Method");
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("After excecuting each test method");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("This will excute after the class");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("This will excute after all the test is executed");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("This will execute after evertything at the end");
	}
}