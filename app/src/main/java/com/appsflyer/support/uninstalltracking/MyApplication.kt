package com.appsflyer.support.uninstalltracking

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib

class MyApplication: Application(), AppsFlyerConversionListener {
    val appsFlyerDevKey: String = "SC6zv6Zb6N52vePBePs5Xo"
    val senderId = "626923654901"
    override fun onCreate() {
        super.onCreate()
        Log.d(AppsFlyerLib.LOG_TAG,  "[NoviceApplication][onCreate]")
        AppsFlyerLib.getInstance().setDebugLog(true)
        AppsFlyerLib.getInstance().enableUninstallTracking(senderId)
        AppsFlyerLib.getInstance().init(appsFlyerDevKey, this, applicationContext)
        AppsFlyerLib.getInstance().startTracking(this)
    }


    override fun onAppOpenAttribution(conversionData: MutableMap<String, String>?) {
        Log.d(AppsFlyerLib.LOG_TAG, "[MyApplication][onAppOpenAttribution]")
        conversionData?.let { data ->
            data.map { "key: ${it.key} Value: ${it.value}" }.forEach {
                Log.d(AppsFlyerLib.LOG_TAG, "onAppOpenAttribution $it")
            }
        }
    }

    override fun onAttributionFailure(p0: String?) {
        Log.d(AppsFlyerLib.LOG_TAG, "[MyApplication] [onAttributionFailure] $p0")
    }

    override fun onInstallConversionDataLoaded(conversionData: MutableMap<String, String>?) {
        Log.d(AppsFlyerLib.LOG_TAG, "[MyApplication][onInstallConversionDataLoaded]")
        conversionData?.let { data ->
            data.map { "key: ${it.key} Value: ${it.value}" }.forEach {
                Log.d(AppsFlyerLib.LOG_TAG, it)
            }
        }
    }

    override fun onInstallConversionFailure(p0: String?) {
        Log.d(AppsFlyerLib.LOG_TAG, "[MyApplication][onInstallConversionFailure] $p0")
    }

}