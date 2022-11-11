package com.lunn.store.disk

/**
 * @author dulang
 * @date 2022/11/3
 * @description
 * @note
 */
interface DiskReadWrite<Raw, Key> : DiskRead<Raw, Key>, DiskWrite<Raw, Key> {

    override suspend fun read(key: Key): Raw?

    override suspend fun write(key: Key, raw: Raw): Boolean
}