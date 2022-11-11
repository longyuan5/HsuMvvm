package com.lunn.store.disk

import okio.BufferedSource

/**
 * Converts Java values to JSON.
 */
interface BufferedSourceAdapter<Parsed> {
    fun toJson(value: Parsed): BufferedSource
}
