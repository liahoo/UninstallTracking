package com.appsflyer.support.uninstalltracking

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID



class RegistrationIntentService() : IntentService("GCM") {
    override fun onHandleIntent(intent: Intent?) {
        val instanceID = InstanceID.getInstance(this)
        val token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)
        /* ... */
        Log.d(AppsFlyerLib.LOG_TAG, "[onHandleIntent] ${intent?.action} ${intent?.data} ")
        Log.d(AppsFlyerLib.LOG_TAG, "[updateServerUninstallToken] token: \n$token ")
        AppsFlyerLib.getInstance().updateServerUninstallToken(getApplicationContext(), token); // pass the token to the AppsFlyer SDK

    }
}