package com.ihorvitruk.telegramclient.splash

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.ihorvitruk.telegramclient.base.BaseView
import com.ihorvitruk.telegramclient.splash.databinding.SplashViewBinding

class SplashView : BaseView<SplashViewBinding, SplashViewModel> {

    constructor(context: Context?, viewModel: SplashViewModel) : super(context, viewModel)
    constructor(context: Context?, attrs: AttributeSet?, viewModel: SplashViewModel) : super(context, attrs, viewModel)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, viewModel: SplashViewModel) : super(context, attrs, defStyleAttr, viewModel)

    override fun initBinding(inflater: LayoutInflater) = SplashViewBinding.inflate(inflater, this, true)

    override fun initViewModel(binding: SplashViewBinding?, viewModel: SplashViewModel) {
        binding?.viewModel = viewModel
    }
}