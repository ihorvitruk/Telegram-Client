package com.ihorvitruk.telegramclient.presentation.login.phone

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import com.ihorvitruk.telegramclient.presentation.base.BaseView
import com.ihorvitruk.telegramclient.presentation.login.databinding.LoginPhoneViewBinding

@SuppressLint("ViewConstructor")
class LoginPhoneView(context: Context?, viewModel: LoginPhoneViewModel)
    : BaseView<LoginPhoneViewBinding, LoginPhoneViewModel>(context, viewModel) {

    override fun initBinding(inflater: LayoutInflater): LoginPhoneViewBinding? =
            LoginPhoneViewBinding.inflate(inflater, this, true)

    override fun initViewModel(binding: LoginPhoneViewBinding?, viewModel: LoginPhoneViewModel) {
        binding?.viewModel = viewModel
    }
}