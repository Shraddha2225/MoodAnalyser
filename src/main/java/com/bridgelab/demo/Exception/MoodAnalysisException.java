package com.bridgelab.demo.Exception;

public class MoodAnalysisException extends Exception{
    public MoodAnalysisException(EnumTest enumTest, String message) {
        super(message);
        this.enumTest=enumTest;
    }
    public enum EnumTest{
        EMPTY ,NULL
    }
    public EnumTest enumTest;
}
