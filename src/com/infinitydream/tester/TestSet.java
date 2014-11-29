package com.infinitydream.tester;

public class TestSet {
    private char[] eqnSequence;
    private String expectedResults;
    private String actualResults;
    private boolean success;

    //getters and setters
    public char[] getEqnSequence() {
	return eqnSequence;
    }

    public void setEqnSequence(char[] eqnSequence) {
	this.eqnSequence = eqnSequence;
    }

    public String getExpectedResults() {
	return expectedResults;
    }

    public void setExpectedResults(String expectedResults) {
	this.expectedResults = expectedResults;
    }

    public String getActualResults() {
	return actualResults;
    }

    public void setActualResults(String actualResults) {
	this.actualResults = actualResults;
    }

    public boolean isSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }
}
