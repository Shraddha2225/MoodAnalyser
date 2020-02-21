package com.bridgelab.demo.Exception;
import com.bridgelab.demo.MoodAnalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser() {
        try {
            Class<?> MoodAnalyserClass = Class.forName("com.bridgelab.demo.MoodAnalyser");
            Constructor<?> moodconstructor = MoodAnalyserClass.getConstructor();
            Object moodobj = moodconstructor.newInstance();
            MoodAnalyser moodAnalyser = (MoodAnalyser) moodobj;
            return moodAnalyser;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Constructor<?> getConstructor(String param ,Class getMethod) throws MoodAnalysisException{
        try {
            Class<?> moodAnalyserClass = Class.forName(param);
            return moodAnalyserClass.getConstructor(getMethod);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_CLASS,e.getMessage());
        }catch(NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_METHOD,e.getMessage());
        }
    }
}
