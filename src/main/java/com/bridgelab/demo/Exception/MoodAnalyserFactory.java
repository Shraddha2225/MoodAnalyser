package com.bridgelab.demo.Exception;
import com.bridgelab.demo.MoodAnalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String s) {
        try {
            Class<?> MoodAnalyserClass = Class.forName("com.bridgelab.demo.MoodAnalyser");
            Constructor<?> moodconstructor = MoodAnalyserClass.getConstructor(String.class);
            Object moodobj = moodconstructor.newInstance("I Am In Happy Mood");
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
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_CLASS,"Class Not Found");
        }catch(NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_METHOD,"Method Not Found");
        }
    }
    public static String invokedMethodWithReflection(Object moodObject, String method) throws MoodAnalysisException {
        try {
            Method reflectMood = moodObject.getClass().getDeclaredMethod(method);
            return (String) reflectMood.invoke(moodObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_METHOD,"Method Name Is Improper");
        }
        return null;
    }
    public static String invokedFieldWithReflection(Object moodAnalyser,String fieldName,String fieldValue) throws MoodAnalysisException {
        try {
            Field declaredField = moodAnalyser.getClass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(moodAnalyser,fieldValue);
            return (String) moodAnalyser.getClass().getDeclaredMethod("analyseMood").invoke(moodAnalyser);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.NO_SUCH_FIELD,"Field Not Found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumTest.INVOKE_NULL,"Invocation Error");
        }
        return "fieldName";
    }
}
