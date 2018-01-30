package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import com.ihorvitruk.telegramclient.domain.repository.IAccountRepository
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel

class SplashViewModel(private val accountRepository: IAccountRepository) : BaseViewModel() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        title.postValue("Hello 2")
    }

    private fun loadData() {
        execute(accountRepository.readAccount(),
                { Toast.makeText(this@MainActivity, account.toString(), Toast.LENGTH_LONG).show() },
                { t ->
                    Toast.makeText(this@MainActivity,
                            "Throwable: " + t.message, Toast.LENGTH_LONG).show()
                }
        )
    }
}

