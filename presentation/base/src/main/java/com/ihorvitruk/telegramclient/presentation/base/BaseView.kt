package com.ihorvitruk.telegramclient.presentation.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast

abstract class BaseView<B : ViewDataBinding, VM : BaseViewModel<*>> : FrameLayout {

    constructor(context: Context?, viewModel: VM)
            : super(context) {
        init(context, null, 0, viewModel)
    }

    constructor(context: Context?, attrs: AttributeSet?, viewModel: VM)
            : super(context, attrs) {
        init(context, attrs, 0, viewModel)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, viewModel: VM)
            : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr, viewModel)
    }

    protected abstract fun initBinding(inflater: LayoutInflater): B?

    protected abstract fun initViewModel(binding: B?, viewModel: VM)

    private fun init(context: Context?, attrs: AttributeSet?,
                     defStyleAttr: Int, viewModel: VM) {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = initBinding(inflater)
        binding?.setLifecycleOwner(context as? LifecycleOwner)
        initViewModel(binding, viewModel)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("showError")
        fun showError(container: View, errorText: String?) {
            if (!TextUtils.isEmpty(errorText)) {
                Toast.makeText(container.context, errorText, Toast.LENGTH_LONG).show()
            }
        }
    }
}