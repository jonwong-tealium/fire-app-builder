package com.amazon.analytics.tealium;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amazon.analytics.AnalyticsTags;
import com.amazon.analytics.CustomAnalyticsTags;
import com.amazon.analytics.IAnalytics;
import com.tealium.library.Tealium;

import java.util.HashMap;

public class TealiumAnalytics implements IAnalytics {

    private static final String TAG = TealiumAnalytics.class.getSimpleName();

    private Tealium mTealium;
    private CustomAnalyticsTags mCustomAnalyticsTags = new CustomAnalyticsTags();

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(Context context) {
        Application application = (Application) context.getApplicationContext();
        Tealium.Config config = Tealium.Config.create(application, "<account-name>", "<profile-name>", "<environment>");
        mTealium = Tealium.createInstance("<instance-name>", config);

        Log.d(TAG, "Tealium Analytics initialized");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collectLifeCycleData(Activity activity, boolean active) {
        Log.d(TAG, "Lifecycle is not supported for this platform.");
    }

    /**
     * {@inheritDoc}
     *
     * @param data Map of Strings to Objects that represent data that is necessary for the tracked
     */
    @Override
    public void trackAction(HashMap<String, Object> data) {
        HashMap<String, Object> contextData = new HashMap<>();

        // Get the action name
        String action = String.valueOf(data.get(AnalyticsTags.ACTION_NAME));
        contextData.put(AnalyticsTags.ACTION_NAME, action);

        // Get the attributes map
        HashMap<String, Object> contextDataObjectMap = (HashMap<String, Object>) data.get(AnalyticsTags.ATTRIBUTES);

        if (action != null && contextDataObjectMap != null) {
            for (String key : contextDataObjectMap.keySet()) {
                contextData.put(key, String.valueOf(contextDataObjectMap.get(key)));
            }

            mTealium.trackEvent(mCustomAnalyticsTags.getCustomTag(action),
                    mCustomAnalyticsTags.getCustomTags(contextData));
            Log.d(TAG, "Track action " + action + "with attributes " + contextData);
        }
    }

    @Override
    public void trackState(String screen) {
        mTealium.trackView(screen, null);
        Log.d(TAG, "Track screen: " + screen);
    }

    @Override
    public void trackCaughtError(String errorMessage, Throwable t) {
        mTealium.trackEvent(errorMessage, null);
        Log.d(TAG, "Tracking caught error: " + errorMessage);
    }
}
