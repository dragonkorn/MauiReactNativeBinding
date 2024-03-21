package com.example.testlib

import android.app.Activity
import android.view.View
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
            .setUseDeveloperSupport(BuildConfig.DEBUG) // Use your debug flag here
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
}