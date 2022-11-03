@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package com.lunn.common.ktx.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * @author dulang
 * @date 2022/7/20
 * @description LifecycleOwner的扩展
 * @note
 */

@kotlin.internal.InlineOnly
inline fun <T> LifecycleOwner.observeLiveData(
    liveData: LiveData<T>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(this) { it?.let { t -> action(t) } }
}
