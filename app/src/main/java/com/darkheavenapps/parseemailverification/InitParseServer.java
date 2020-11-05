package com.darkheavenapps.parseemailverification;

import android.app.Application;
import com.parse.Parse;

public class InitParseServer extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3C28EhwLoegZTeVuzq66y6QU2pjpZzTeE6cvF3gU")
                .clientKey("YpsBWg2VFOZqCYI2FatPymi5Zs9QIQ2CDA2Hk959")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
