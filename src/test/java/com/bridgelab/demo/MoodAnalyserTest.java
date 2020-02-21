package com.bridgelab.demo;

import com.bridgelab.demo.Exception.MoodAnalyserFactory;
import com.bridgelab.demo.Exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test
    public void givenMoodShouldReturnHappy() throws MoodAnalysisException {
        String mood = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Happy Mood");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodShouldReturnSad() throws MoodAnalysisException {
        String mood = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Sad Mood");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldReturnException() throws MoodAnalysisException {
        String mood = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.EnumTest.ENTER_NULL, e.enumTest);
        }
    }

    @Test
    public void givenEmptyMoodShouldReturnException() throws MoodAnalysisException {
        String mood = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.EnumTest.ENTER_EMPTY, e.enumTest);
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelab.demo.MoodAnalyser").getConstructor(String.class);
            try {
                Object object = constructor.newInstance("I Am In A Happy Mood");
                MoodAnalyser objectmood = (MoodAnalyser) object;
                String mood = objectmood.analyseMood();
                Assert.assertEquals("HAPPY", mood);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyserClassDefault_WhenProper_ShouldReturnObject() {
        MoodAnalyser analyser = MoodAnalyserFactory.createMoodAnalyser();
        Assert.assertEquals(analyser, new MoodAnalyser());
    }
    @Test
    public void givenMoodReflector_WhenClassNotFound_ShouldReturnException() throws MoodAnalysisException {
        try {
            MoodAnalyserFactory.getConstructor("com.bridgelab.demo.MoodAnalyserSet",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.EnumTest.NO_SUCH_CLASS, e.enumTest);
        }
    }
    @Test
    public void givenMoodReflector_WhenMethodNotFound_ShouldReturnException() throws MoodAnalysisException {
        try {
            MoodAnalyserFactory.getConstructor("com.bridgelab.demo.MoodAnalyser",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.EnumTest.NO_SUCH_METHOD, e.enumTest);
        }
    }

    @Test
    public void givenMoodAnalyserParameterizedClass_WhenNoSuchClassError_ShouldReturnException() {

    }
}
