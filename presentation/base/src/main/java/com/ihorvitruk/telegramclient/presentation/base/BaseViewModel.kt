package com.ihorvitruk.telegramclient.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import java.lang.ref.WeakReference

abstract class BaseViewModel<R : BaseRouter> : ViewModel() {

    private var weakRouter: WeakReference<R?> = WeakReference(null)

    var router: R?
        get() = weakRouter.get()
        set(value) {
            weakRouter = WeakReference(value)
        }

    val errorText = MutableLiveData<String>()

    open fun onCreate() = Unit

    open fun onDestroy() = Unit

    protected fun <T> execute(job: Deferred<T>,
                              onComplete: (T) -> Unit,
                              onError: (Throwable) -> Unit) = async(UI) {
        try {
            onComplete.invoke(job.await())
        } catch (t: Throwable) {
            onError.invoke(t)
        }
    }
}