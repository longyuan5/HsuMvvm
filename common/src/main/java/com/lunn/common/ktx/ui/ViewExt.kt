@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package com.lunn.common.ktx.ui

import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.contracts.ExperimentalContracts


@kotlin.internal.InlineOnly
inline fun View.visible() {
    visibility = View.VISIBLE
}

@kotlin.internal.InlineOnly
inline fun View.gone() {
    visibility = View.GONE
}

@kotlin.internal.InlineOnly
inline fun View.invisible() {
    visibility = View.INVISIBLE
}

@kotlin.internal.InlineOnly
inline fun View.showShortSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}

@kotlin.internal.InlineOnly
inline fun View.showShortSnackbar(@StringRes stringResId: Int) {
    Snackbar.make(this, stringResId, Snackbar.LENGTH_SHORT).show()
}

@kotlin.internal.InlineOnly
inline fun View.showLongSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

@kotlin.internal.InlineOnly
inline fun View.showLongSnackbar(@StringRes stringResId: Int) {
    Snackbar.make(this, stringResId, Snackbar.LENGTH_LONG).show()
}

@kotlin.internal.InlineOnly
inline fun View.showActionSnackBar(
    message: String,
    actionName: String,
    noinline listener: () -> Unit
) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction(actionName) {
            listener()
        }.show()
}

/**
 * 快捷设置View的自定义纯色带圆角背景
 *
 * @receiver View
 * @param color Int 颜色值
 * @param cornerRadius Float 圆角 单位px
 */
@kotlin.internal.InlineOnly
inline fun View.setRoundRectBg(
    @ColorInt color: Int,
    cornerRadius: Float = 15F
) {
    background = GradientDrawable().apply {
        setColor(color)
        setCornerRadius(cornerRadius)
    }
}
