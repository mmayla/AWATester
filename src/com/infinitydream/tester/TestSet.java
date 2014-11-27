package com.infinitydream.tester;

public class TestSet {
    private char[] eqnSequence;
    private float expectedResults;
    private float actualResults;
    private boolean success;

    //getters and setters
    public char[] getEqnSequence() {
	return eqnSequence;
    }

    public void setEqnSequence(char[] eqnSequence) {
	this.eqnSequence = eqnSequence;
    }

    public float getExpectedResults() {
	return expectedResults;
    }

    public void setExpectedResults(float expectedResults) {
	this.expectedResults = expectedResults;
    }

    public float getActualResults() {
	return actualResults;
    }

    public void setActualResults(float actualResults) {
	this.actualResults = actualResults;
    }

    public boolean isSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }
}
