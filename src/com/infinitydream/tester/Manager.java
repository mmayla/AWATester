package com.infinitydream.tester;

import java.util.List;

public class Manager {

    public static boolean runTest(String url, String infPath, String outfPath) {
	try {
	    // parse the test set input file
	    Parser p = new Parser();
	    p.Parse(infPath);
	    List<TestSet> tslist = p.getListTestSet();

	    // test the web calculator
	    WebTester wt = new WebTester();
	    wt.setUp();
	    wt.setUpList(tslist);
	    wt.testList(url);
	    wt.tearDown();
	    
	    // generate results file
	    ResultsGenerator.generateResults(tslist, outfPath);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}

	return true;
    }
    
    //***** TEST METHODS *****//
    public static void main(String[] args) {
	String url = "file:///home/divoo/workspace/4th_year_workspace/CalculatorTester/WebCalculator/index.html";
	String filepath = "/home/divoo/workspace/4th_year_workspace/CalculatorTester/testcases/testcase";
	String outfilepath = "/home/divoo/workspace/4th_year_workspace/CalculatorTester/testcases/outtestcase";
	
	runTest(url, filepath, outfilepath);
    }
}
