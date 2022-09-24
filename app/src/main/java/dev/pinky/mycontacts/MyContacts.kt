package dev.pinky.mycontacts

import android.app.Application
import android.content.Context

class MyContacts: Application() {
    companion object {
        lateinit var  appContext : Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}