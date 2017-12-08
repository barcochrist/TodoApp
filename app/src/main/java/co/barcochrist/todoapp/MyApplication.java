package co.barcochrist.todoapp;

import android.app.Application;

import co.barcochrist.todoapp.database.AppDatabase;

/**
 * Created by christianbarco on 5/12/17.
 * Se modifica el mnifest para llamar el método definido en esta clase.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.init(getApplicationContext());
    }
}
