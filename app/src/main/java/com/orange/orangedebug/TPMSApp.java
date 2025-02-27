package com.orange.orangedebug;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

/**
 * 进程唯一的Application
 * Created by haide.yin() on 2019/3/26 14:35.
 */
public class TPMSApp extends Application {

    public static String TAG = TPMSApp.class.getSimpleName();
    private Thread.UncaughtExceptionHandler restartHandler = (thread, ex) -> {
        Log.e("error",ex.getMessage());
        restartApp();
    };
    @Override
    public void onCreate() {
        super.onCreate();
        //最后统一调用初始化硬件
//        Thread.setDefaultUncaughtExceptionHandler(restartHandler);
//        MTest mTest = new MTest();
//        mTest.setContext(this);
//        mTest.setTPMS(this);
        //mTest.run();

    }
    public void restartApp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
