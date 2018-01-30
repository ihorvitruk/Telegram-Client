package com.ihorvitruk.telegramclient.presentation.splash

import android.content.Context
import android.view.LayoutInflater
import com.ihorvitruk.telegramclient.presentation.base.BaseView
import com.ihorvitruk.telegramclient.presentation.splash.databinding.SplashViewBinding

class SplashView(context: Context?, viewModel: SplashViewModel)
    : BaseView<SplashViewBinding, SplashViewModel>(context, viewModel) {

    override fun initBinding(inflater: LayoutInflater)
            = SplashViewBinding.inflate(inflater, this, true)

    override fun initViewModel(binding: SplashViewBinding?, viewModel: SplashViewModel) {
        binding?.viewModel = viewModel
    }
}