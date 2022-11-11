package com.lunn.store.disk

interface DiskAllErase {
    suspend fun deleteAll(path: String): Boolean
}
