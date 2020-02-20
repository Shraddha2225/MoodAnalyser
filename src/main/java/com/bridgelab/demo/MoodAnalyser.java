package com.bridgelab.demo;

import com.bridgelab.demo.Exception.MoodAnalysisException;
public class MoodAnalyser {

    private static String message;

    public MoodAnalyser(String message) {
        this.message=message;
    }
    public static String analyseMood() throws MoodAnalysisException {
        try {
            if(message.isEmpty())
            {
                throw new MoodAnalysisException(MoodAnalysisException.EnumTest.EMPTY,"please enter a value it can not be empty");
            }
            if (message.contains("Happy")) {
                return "HAPPY";
            }
            else
                return "SAD";
        }
        catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NULL,"please enter proper message");
        }
    }
}





