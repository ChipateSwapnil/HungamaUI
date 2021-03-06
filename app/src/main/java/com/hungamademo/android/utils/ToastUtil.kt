package com.hungamademo.android.utils

import android.content.Context
import android.widget.Toast

class ToastUtil {
    companion object {
        fun showShortToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}