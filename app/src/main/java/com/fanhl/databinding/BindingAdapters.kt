package com.fanhl.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

// @RestrictTo(RestrictTo.Scope.LIBRARY)
@BindingMethods(
    BindingMethod(type = TextView::class, attribute = "android:paddingLeft", method = "setPaddingLeft")
)
object BindingAdapters {
    @BindingAdapter("android:paddingLeft")
    @JvmStatic
    fun setPaddingLeft(view: TextView, padding: Int) {
        view.setPadding(padding, padding, padding, padding)
    }
}