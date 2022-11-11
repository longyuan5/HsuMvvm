package com.lunn.store.disk

interface DiskErase<Raw, Key> {
    suspend fun delete(key: Key): Boolean
}
