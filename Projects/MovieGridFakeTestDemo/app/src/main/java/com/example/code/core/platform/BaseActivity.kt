package com.example.code.core.platform

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.code.R
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    internal fun notifyWithAction(
            view : View,
            @StringRes message: Int,
            @StringRes actionText: Int,
            action: () -> Any
    ) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(ContextCompat.getColor(this@BaseActivity, R.color.colorTextPrimary))
        snackBar.show()
    }

}
