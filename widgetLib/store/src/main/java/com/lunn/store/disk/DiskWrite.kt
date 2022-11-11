package com.lunn.store.disk

import java.io.IOException

/**
 * @author dulang
 * @date 2022/11/3
 * @description 磁盘保存操作接口
 * @note
 * @param Raw 要保存的原数据
 * @param Key 标识[Raw]的唯一键
 */
interface DiskWrite<Raw, Key> {

    /**
     * @return 如果写入成功返回true，否则返回false；写入过程中异常抛异常。
     */
    @Throws(IOException::class)
    suspend fun write(key: Key, raw: Raw) : Boolean
}
