package com.bridgelab.demo;

import com.bridgelab.demo.Exception.MoodAnalysisException;
public class MoodAnalyser {
    private static String message;
    public MoodAnalyser() {
        this.message="default";
    }
    public MoodAnalyser(String message) {
        this.message = message;
    }
    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }
    public static String analyseMood() throws MoodAnalysisException {
        try {
            if (message.isEmpty()) {
                if (message.length() == 0)
                    throw new MoodAnalysisException(MoodAnalysisException.EnumTest.ENTER_EMPTY, "please enter a value it can not be empty");
            }
            if (message.contains("Happy")) {
                return "HAPPY";
            } else
                return "SAD";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.ENTER_NULL, "please enter proper message");
        }
    }
    public boolean equals(Object another){
        if (this.message.equals(((MoodAnalyser)another).message)) {
            return true;
        }
        return false;
    }

}



