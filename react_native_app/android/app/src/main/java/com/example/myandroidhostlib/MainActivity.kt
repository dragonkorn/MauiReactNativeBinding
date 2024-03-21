package com.example.myandroidhostlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
//import com.facebook.react.ReactActivity
import android.os.Bundle
import android.widget.Button
import com.example.testlib.HelloActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declare button from activity_main.xml
        val button = findViewById<Button>(R.id.next_button)
        // add onclick listener to button
        button.setOnClickListener {
            onButtonClicked(1)
        }

        val buttonRn = findViewById<Button>(R.id.react_native_button)
        buttonRn.setOnClickListener {
            onButtonClicked(2)
        }
    }

    // onclick method for button in activity_main.xml
    private fun onButtonClicked(index : Int) {
        if (index == 1) {
            // start HelloActivity
            val intent = Intent(this, com.example.testlib.MyReactActivity::class.java)
            startActivity(intent)
        } else {
            // start MyReactActivity
            val intent = Intent(this, MyReactActivity::class.java)
            startActivity(intent)
        }
    }
}

//package com.example.myandroidhostlib
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.facebook.react.ReactActivity
//import com.facebook.react.ReactInstanceManager
//import com.facebook.react.ReactInstanceManagerBuilder
//import com.facebook.react.ReactNativeHost
//import com.facebook.react.common.LifecycleState
//import com.facebook.react.shell.MainReactPackage
//import com.facebook.soloader.SoLoader
//
//class MainActivity : ReactActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//        loadBundle()
//    }
//
//    private fun loadBundle() {
//        val reactNativeHost = object : ReactNativeHost(this.application) {
//            override fun getUseDeveloperSupport(): Boolean {
//                return false // Set this to true to enable development mode
//            }
//
//            override fun getJSMainModuleName(): String {
//                return "index.android" // Set the entry file name
//            }
//
//            override fun getBundleAssetName(): String {
//                return "index.android.bundle" // Set the bundle file name
//            }
//        }
//
//        val reactInstanceManager: ReactInstanceManager = reactNativeHost.reactInstanceManagerBuilder
//            .setApplication(application)
//            .setCurrentActivity(this)
//            .setJSBundleFile(reactNativeHost.getJSBundleFile())
//            .setInitialLifecycleState(LifecycleState.RESUMED)
//            .build()
//
//        reactInstanceManager.onCreate(savedInstanceState)
//    }
//
//    override fun getMainComponentName(): String? {
//        return null // Return null to prevent react-native from rendering the default component
//    }
//}