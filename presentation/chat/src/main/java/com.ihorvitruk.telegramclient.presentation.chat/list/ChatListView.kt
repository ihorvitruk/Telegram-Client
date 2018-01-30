package com.ihorvitruk.telegramclient.presentation.chat.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import com.ihorvitruk.telegramclient.presentation.base.BaseView
import com.ihorvitruk.telegramclient.presentation.chat.databinding.ChatListViewBinding

@SuppressLint("ViewConstructor")
class ChatListView(context: Context?, viewModel: ChatListViewModel)
    : BaseView<ChatListViewBinding, ChatListViewModel>(context, viewModel) {

    override fun initBinding(inflater: LayoutInflater): ChatListViewBinding? =
            ChatListViewBinding.inflate(inflater, this, true)

    override fun initViewModel(binding: ChatListViewBinding?, viewModel: ChatListViewModel) {
        binding?.viewModel = viewModel
    }
}