package com.bridgelab.demo;

import com.bridgelab.demo.Exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMoodShouldReturnHappy() throws MoodAnalysisException {
        String mood=null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Happy Mood");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        }catch(MoodAnalysisException e)
        {
            //Assert.assertEquals("please enter proper message",e.getMessage());
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodShouldReturnSad() throws MoodAnalysisException {
        String mood=null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Sad Mood");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        }catch(MoodAnalysisException e)
        {
            //Assert.assertEquals("please enter proper message",e.getMessage());
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMoodShouldReturnException() throws MoodAnalysisException {
        String mood=null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        }catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.EnumTest.NULL,e.enumTest);
            //e.printStackTrace();
        }

    }
    @Test
    public void givenEmptyMoodShouldReturnException() throws MoodAnalysisException {
        String mood =null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        }catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.EnumTest.EMPTY,e.enumTest);
            e.printStackTrace();
        }
    }

}
