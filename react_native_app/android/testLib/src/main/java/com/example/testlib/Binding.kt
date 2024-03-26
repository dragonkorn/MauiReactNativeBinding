package com.example.testlib

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.example.testlib.BuildConfig.*
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage

class Binding {
    fun GetReactNativeView(activity: Activity): View {
        // Create a ReactRootView instance
        val reactRootView = ReactRootView(activity)

        // Create a ReactInstanceManager
        val reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(activity.application)
            .setCurrentActivity(activity)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index.android")
            .addPackage(MainReactPackage())
            .setUseDeveloperSupport(DEBUG) // Use your debug flag here
            .setInitialLifecycleState(com.facebook.react.common.LifecycleState.RESUMED)
            .build()

        // Start the React application
        reactRootView.startReactApplication(reactInstanceManager, "YourRootComponent", null)

        // Implement back button handling if necessary
        if (activity is DefaultHardwareBackBtnHandler) {
            reactInstanceManager.onHostResume(activity)
        }

        return reactRootView
    }

    fun createViewFromAppCompat(activity: Activity): View {
        val textView = AppCompatTextView(activity) // Use AppCompatTextView from appcompat
        textView.apply {
            text = "Hello world from android x!!"
            setBackgroundColor(Color.GREEN)
            setTextColor(Color.WHITE)
            textSize = 24f
            gravity = Gravity.CENTER
        }
        return textView
    }

    fun createHelloWorldView(activity: Activity): View {
        val textView = TextView(activity)
        textView.apply {
            text = "Hello World!!"
            setBackgroundColor(Color.GREEN)
            setTextColor(Color.WHITE)
            textSize = 24f
            gravity = Gravity.CENTER
        }
        return textView
    }
}