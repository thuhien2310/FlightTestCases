package newpage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class VeMayBay {
	//private WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException 
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();

		testng.addListener(tla);
		// testng.setTestClasses(new Class[] { test.TestTitle.class });

		List<String> suites = Lists.newArrayList();
		suites.add("testng.xml");// path to xml..
		// // suites.add("c:/tests/testng2.xml");
		//
		testng.setTestSuites(suites);

		testng.run();
				
		}

}
