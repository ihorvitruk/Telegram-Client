package com.ihorvitruk.telegramclient.presentation.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    open fun onCreate() = Unit
    open fun onResume() = Unit
    open fun onPause() = Unit
    open fun onDestroy() = Unit
}