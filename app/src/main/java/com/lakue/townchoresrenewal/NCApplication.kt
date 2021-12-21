package com.lakue.townchoresrenewal

import android.app.Application
import android.content.Context

class NCApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object {

        var appContext: Context? = null
            private set

    }

}