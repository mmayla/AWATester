package com.infinitydream.tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private File text;
    private Scanner sc;
    private List<TestSet> ListTestSet = new ArrayList<TestSet>();
    TestSet T;

    public Parser() {

    }

    public void Parse(String path) {
	text = new File(path);
	try {
	    sc = new Scanner(text);
	    while (sc.hasNextLine()) {
		T = new TestSet();
		T.setHandle(sc.nextLine());
		T.setEqnSequence(sc.nextLine().replaceAll("\\s", "")
			.toCharArray());
		T.setExpectedResults(sc.nextLine());

		ListTestSet.add(T);
	    }
	}

	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

    }

    public List<TestSet> getListTestSet() {
	return this.ListTestSet;
    }

}
