package com.infinitydream.tester;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;





import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
@SuppressWarnings("unused")
public class WebTester {
	  
	  private Parser P = new Parser();
	  private List<TestSet> currList = new ArrayList<TestSet>();
		
	//Path path = Paths.get("");
	  private WebDriver driver;
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	  }
	 
	  // get list of Test Sets from Parser 
	  @Before
	  public void setUpList() throws Exception {
		  //Add the testcase file path here
		  P.Parse("C:\\Users\\Raneem\\git\\calculator-tester\\testcase.txt");
		  currList = P.getListTestSet();
		  }

	  @Test
	  public void testList() throws Exception {
		  // change it to your local host till we host it on a free host online
	
		  //Open page
		  driver.get("file:///C:/Users/Raneem/git/calculator-tester/WebCalculator/index.html");
		  
		  TestSet T= new TestSet();
		  char[] eqn;
		  WebElement W;
		  for (int i=0; i<currList.size(); i++)
		  {
			  T=currList.get(i);
			  eqn=T.getEqnSequence();
			  String chid;
			  for (int j=0;j<eqn.length; j++)
			  {
				  chid =Character.toString(eqn[j]);
				  try
				  {
				  driver.findElement(By.id(chid)).click();
				  }
				  catch (NoSuchElementException e)
				  {
					  
				  }
			  }
			
			  driver.findElement(By.id("=")).click();
		     
			  //Save Results
		      W= driver.findElement(By.className("results"));
			  T.setActualResults(W.getText());
			  if(T.getExpectedResults()==T.getActualResults())
			  {
				  T.setSuccess(true);  	  
			  }
			  currList.set(i, T);
			  driver.findElement(By.id("AC")).click();
		  }
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    }
	  
	    public List<TestSet> getcurrList() {
			return this.currList;
		    }
	  }