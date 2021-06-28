package com.example.code.test;

import android.app.Application;
import android.content.Context;
import androidx.test.runner.AndroidJUnitRunner;
import com.example.code.injection.TestRecipeApplication;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
