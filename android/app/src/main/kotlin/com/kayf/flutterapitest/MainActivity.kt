package com.kayf.flutterapitest

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "flutter.native/client"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "helloNative") {
                val batteryLevel = "Hello there!"

                if (batteryLevel != null) {
                    result.success(batteryLevel)
                } else {
                    result.error("UNAVAILABLE", "Battery level not available.", null)
                }
            } else {
                result.notImplemented()
            }
        }
    }
}

//
//import android.os.Bundle;
//import androidx.annotation.NonNull
//import io.flutter.app.FlutterActivity;
//import io.flutter.embedding.engine.FlutterEngine
//import io.flutter.plugin.common.MethodCall;
//import io.flutter.plugin.common.MethodChannel;
//import io.flutter.plugins.GeneratedPluginRegistrant;
//
//
//
//class MainActivity: FlutterActivity() {
//
//    private val CHANNEL = "flutter.native/helper"
//
////    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
////        GeneratedPluginRegistrant.registerWith(flutterEngine);
////    }
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        GeneratedPluginRegistrant.registerWith(this)
//        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
//            if (call.method == "helloFromNativeCode") {
//                val greetings = helloFromNativeCode()
//                result.success(greetings)
//            }
//        }
//    }
//
//    private fun helloFromNativeCode(): String {
//        return "Hello from Native Android Code"
//    }
//}
