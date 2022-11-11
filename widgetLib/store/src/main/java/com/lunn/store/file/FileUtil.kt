package com.lunn.store.file

import java.io.File
import java.io.IOException
import java.util.Stack

object FileUtil {

    /**
     * 重新用/组装path：用于屏蔽不同平台的path路径格式
     */
    fun simplifyPath(path: String): String {
        if (ifInvalidPATH(path)) {
            return ""
        }
        val splitRegex = "[/]+"
        val arr = path.split(splitRegex.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val stack = Stack<String>()
        fillStack(arr, stack)

        if (stack.isEmpty()) {
            return "/"
        }

        val sb = StringBuilder()

        for (str in stack) {
            sb.append("/").append(str)
        }

        return sb.toString()
    }

    /**
     * 用[stack] 装填path路径
     */
    private fun fillStack(arr: Array<String>, stack: Stack<String>) {
        for (str in arr) {
            if ("/" == str) {
                continue
            }
            if (".." == str) {
                if (!stack.isEmpty()) {
                    stack.pop()
                }
            } else if ("." != str && str.isNotEmpty()) {
                stack.push(str)
            }
        }
    }

    private fun ifInvalidPATH(path: String?): Boolean =
        path == null || path.trim().isEmpty()

    @Throws(IOException::class)
    fun createParentDirs(file: File) {
        val parent = file.canonicalFile.parentFile ?: return
        parent.mkdirs()
        if (!parent.isDirectory) {
            throw IOException("Unable to create parent directories of $file")
        }
    }
}
