package com.lunn.store.disk


interface DiskRead<Raw, Key> {

    /**
     * 读取失败返回null
     */
    suspend fun read(key: Key): Raw?
}
