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
    private List<TestSet> currList;
    private WebDriver driver;

    @Before
    public void setUp() {
	driver = new FirefoxDriver();
    }

    // get list of Test Sets from Parser
    @Before
    public void setUpList(List<TestSet> tsList) {
	currList = tsList;
    }

    @Test
    public void testList(String url) {
	// Open page
	driver.get(url);

	TestSet T;
	char[] eqn;
	WebElement W;
	for (int i = 0; i < currList.size(); i++) {
	    T = currList.get(i);
	    eqn = T.getEqnSequence();
	    String chid;
	    for (int j = 0; j < eqn.length; j++) {
		chid = Character.toString(eqn[j]);
		try {
		    driver.findElement(By.id(chid)).click();
		} catch (NoSuchElementException e) {

		}
	    }

	    //driver.findElement(By.id("=")).click();

	    // Save Results
	    W = driver.findElement(By.className("results"));
	    T.setActualResults(W.getText());
	    if (T.getExpectedResults().equals(T.getActualResults()))
		T.setSuccess(true);
	    else
		T.setSuccess(false);
	    currList.set(i, T);
	    driver.findElement(By.id("A")).click();
	}
    }

    @After
    public void tearDown() throws Exception {
	driver.quit();
    }

    public List<TestSet> getcurrList() {
	return this.currList;
    }

    /******* TEST METHODS *******/
    public static void main(String[] args) {
	String url = "file:///home/divoo/workspace/4th_year_workspace/CalculatorTester/WebCalculator/index.html";
	String filepath = "/home/divoo/workspace/4th_year_workspace/CalculatorTester/testcase";
	String outfilepath = "/home/divoo/workspace/4th_year_workspace/CalculatorTester/outtestcase";
	
	//parser
	Parser prsr = new Parser();
	prsr.Parse(filepath);
	List<TestSet> tslist = prsr.getListTestSet();
	
	//tester
	WebTester wt = new WebTester();
	wt.setUp();
	wt.setUpList(tslist);
	wt.testList(url);
	
	//results
	ResultsGenerator.generateResults(tslist, outfilepath);
    }
}