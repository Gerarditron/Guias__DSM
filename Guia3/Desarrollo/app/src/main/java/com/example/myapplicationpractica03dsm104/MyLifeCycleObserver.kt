package com.example.myapplicationpractica03dsm104

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleObserver
//import androidx.lifecycle.DefaultLifecycleObserver

class MyLifeCycleObserver : LifecycleObserver {
     override fun onCreate(lifecycler: LifecycleOwner) {
        super.onCreate(lifecycler)
        Log.d("MyLifeCycleObserver", "onCreate")
    }

    override fun onStart(lifecycler: LifecycleOwner) {
        super.onStart(lifecycler)
        Log.d("MyLifeCycleObserver", "onStart")
    }

    override fun onPause(lifecycler: LifecycleOwner) {
        super.onPause(lifecycler)
        Log.d("MyLifeCycleObserver", "onPause")
    }

    override fun onResume(lifecycler: LifecycleOwner) {
        super.onResume(lifecycler)
        Log.d("MyLifeCycleObserver", "onResume")
    }

    override fun onStop(lifecycler: LifecycleOwner) {
        super.onStop(lifecycler)
        Log.d("MyLifeCycleObserver", "onStop")
    }

    override fun onDestroy(lifecycler: LifecycleOwner) {
        super.onDestroy(lifecycler)
        Log.d("MyLifeCycleObserver", "onDestroy")
    }

}