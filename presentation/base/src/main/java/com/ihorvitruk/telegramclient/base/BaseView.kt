package com.ihorvitruk.telegramclient.base

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.databinding.ViewDataBinding
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

abstract class BaseView<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel> : FrameLayout {

    constructor(context: Context?, viewModel: VIEW_MODEL)
            : super(context) {
        init(context, null, 0, viewModel)
    }

    constructor(context: Context?, attrs: AttributeSet?, viewModel: VIEW_MODEL)
            : super(context, attrs) {
        init(context, attrs, 0, viewModel)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, viewModel: VIEW_MODEL)
            : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr, viewModel)
    }

    protected abstract fun initBinding(inflater: LayoutInflater): BINDING?

    protected abstract fun initViewModel(binding: BINDING?, viewModel: VIEW_MODEL)

    private fun init(context: Context?, attrs: AttributeSet?,
                     defStyleAttr: Int, viewModel: VIEW_MODEL) {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = initBinding(inflater)
        binding?.setLifecycleOwner(context as? LifecycleOwner)
        initViewModel(binding, viewModel)
    }
}