package com.amazon.analytics.tealium;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.amazon.analytics.AnalyticsManager;
import com.amazon.analytics.IAnalytics;

import java.util.HashMap;

public class TealiumAnalytics implements IAnalytics {

    private static final String TAG = TealiumAnalytics.class.getSimpleName();


    @Override
    public void configure(Context context) {
        AnalyticsManager analyticsManager = AnalyticsManager.getInstance(context);
        Application application = (Application)context.getApplicationContext();

    }

    @Override
    public void collectLifeCycleData(Activity activity, boolean active) {

    }

    @Override
    public void trackAction(HashMap<String, Object> data) {

    }

    @Override
    public void trackState(String screen) {

    }

    @Override
    public void trackCaughtError(String errorMessage, Throwable t) {

    }
}
