package hudiilfeld.theshoppingequalizer;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by ibm on 05/07/2017.
 */

public class MyApp extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            TypefaceProvider.registerDefaultIconSets();
        }
}
