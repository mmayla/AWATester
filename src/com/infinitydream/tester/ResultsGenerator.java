package com.infinitydream.tester;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultsGenerator {
    private static List<TestSet> failed;
    private static List<TestSet> passed;
    private static File rfile;

    /**
     * create file on the path filedir if not exist
     * 
     * @param filedir
     *            the path of the file
     */
    private static void createFile(String filedir) {
	try {
	    rfile = new File(filedir);
	    rfile.createNewFile();
	} catch (IOException e) {
	}

	System.out.println("file is created");
    }

    /**
     * classify failed and passed testcases
     * 
     * @param testsets
     */
    private static void classify(List<TestSet> testsets) {
	failed = new ArrayList<TestSet>();
	passed = new ArrayList<TestSet>();
	for (TestSet ts : testsets) {
	    if (!ts.isSuccess()) {
		failed.add(ts);
	    } else
		passed.add(ts);
	}
    }

    /**
     * write formatted result to the file
     */
    private static void writeResults() {
	try {
	    FileWriter fw = new FileWriter(rfile);

	    fw.write("No of failed testcases: " + failed.size() + "/"
		    + (failed.size() + passed.size()) + "\n");

	    for (TestSet ts : failed) {
		fw.write(">" + ts.getHandle() + "\n");
		fw.write("\t" + new String(ts.getEqnSequence()) + "\n");
		fw.write("\t" + ts.getExpectedResults() + " <--> "
			+ ts.getActualResults() + "\n");
	    }

	    fw.write("\n\nPassed testcases:\n");
	    for (TestSet ts : passed) {
		fw.write(">" + ts.getHandle() + "\n");
		fw.write("\t" + new String(ts.getEqnSequence()) + "\n");
		fw.write("\t" + ts.getExpectedResults() + " <--> "
			+ ts.getActualResults() + "\n");
	    }

	    fw.close();
	} catch (IOException e) {
	}
    }

    /**
     * 
     * @param testsets
     *            testsets list
     * @param filedir
     *            results file path
     */
    public static void generateResults(List<TestSet> testsets, String filedir) {
	// create result file if not exist
	createFile(filedir);

	// Separate passed and failed testcases
	classify(testsets);

	// write results to the file
	writeResults();
    }

    // ****************** test methods ******************

    public static void test() {
	String dir = "resultfile";
	List<TestSet> tss = new ArrayList<TestSet>();

	char[] eqnChars = {'1','+','3'};
	// errors
	for (int i = 0; i < 5; i++) {
	    TestSet ts1 = new TestSet();
	    ts1.setHandle("TS#" + i + 1);
	    ts1.setEqnSequence(eqnChars);
	    ts1.setExpectedResults("13");
	    ts1.setActualResults("10");
	    ts1.setSuccess(false);
	    tss.add(ts1);
	}

	// correct
	for (int i = 0; i < 5; i++) {
	    TestSet ts1 = new TestSet();
	    ts1.setHandle("TS#" + i + 6);
	    ts1.setEqnSequence(eqnChars);
	    ts1.setExpectedResults("13");
	    ts1.setActualResults("13");
	    ts1.setSuccess(true);
	    tss.add(ts1);
	}
	
	ResultsGenerator.generateResults(tss, dir);
	System.out.println("Test#1 is done");
    }

    public static void main(String[] args) {
	test();
    }
}
