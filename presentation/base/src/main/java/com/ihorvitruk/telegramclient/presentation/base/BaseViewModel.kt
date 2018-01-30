package com.ihorvitruk.telegramclient.presentation.base

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

abstract class BaseViewModel : ViewModel() {

    open fun onCreate() = Unit

    open fun onResume() = Unit

    open fun onPause() = Unit

    open fun onDestroy() = Unit

    protected fun <T> execute(job: Deferred<T>,
                              onComplete: (T) -> Void,
                              onError: (Throwable) -> Void) = async(UI) {
        try {
            onComplete.invoke(job.await())
        } catch (t: Throwable) {
            onError.invoke(t)
        }
    }
}