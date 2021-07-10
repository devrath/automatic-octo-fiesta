package com.example.code.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.example.code.R
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<VIEW_BINDING : ViewBinding>(
    private val inflate: InflateActivity<VIEW_BINDING>
) : AppCompatActivity() {

    lateinit var binding: VIEW_BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate.invoke(layoutInflater)
        setContentView(binding.root)
    }

    internal fun notifyWithAction(
        view: View,
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(
            ContextCompat.getColor(
                this@BaseActivity,
                R.color.colorTextPrimary
            )
        )
        snackBar.show()
    }

}

typealias InflateActivity<T> = (LayoutInflater) -> T
