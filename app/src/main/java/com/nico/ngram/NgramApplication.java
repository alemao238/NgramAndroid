package com.nico.ngram;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nico.ngram.utils.Constants;

/**
 * Created by nico on 24/12/16.
 */

public class NgramApplication extends Application{

    StorageReference storageReference;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference = storage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL);
    }

    public StorageReference getStorageReference() {
        return storageReference;
    }
}
