package com.bridgelab.demo.Exception;

public class MoodAnalysisException extends Exception{
    public MoodAnalysisException(EnumTest enumTest, String message) {
        super(message);
        this.enumTest=enumTest;
    }
    public enum EnumTest{
        ENTER_EMPTY,ENTER_NULL,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_SUCH_FIELD,INVOKE_NULL;
    }
    public EnumTest enumTest;
}
