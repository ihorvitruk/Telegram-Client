package com.ihorvitruk.telegramclient.presentation.splash

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.BindingAdapter
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.ihorvitruk.telegramclient.presentation.base.BaseView
import com.ihorvitruk.telegramclient.presentation.splash.databinding.SplashViewBinding

@SuppressLint("ViewConstructor")
class SplashView(context: Context?, viewModel: SplashViewModel)
    : BaseView<SplashViewBinding, SplashViewModel>(context, viewModel) {

    override fun initBinding(inflater: LayoutInflater)
            = SplashViewBinding.inflate(inflater, this, true)

    override fun initViewModel(binding: SplashViewBinding?, viewModel: SplashViewModel) {
        binding?.viewModel = viewModel
    }

    //Override example! That is AWESOME!
    companion object {
        @JvmStatic
        @BindingAdapter("showError")
        fun showError(container: View, errorText: String?) {
            if (!TextUtils.isEmpty(errorText)) {
                Toast.makeText(container.context, "Changed: " + errorText, Toast.LENGTH_LONG).show()
            }
        }
    }
}