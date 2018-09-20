package com.amazon.analytics.tealium;

public class TealiumTracker {

    public final String INSTANCE_ID = "MY_INSTANCE_ID"; // name is used to track multiple instances of TealiumTracker, but the name itself can be any String

    private static TealiumTracker INSTANCE;

    private TealiumTracker() {

    }

    public static TealiumTracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TealiumTracker();
        }

        return INSTANCE;
    }


}
