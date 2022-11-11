package com.lunn.store.file

import okio.BufferedSink
import okio.BufferedSource
import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

internal class FSFile(root: File, private val pathValue: String) {
    private val file = File(root, pathValue)

    init {
        if (file.exists() && file.isDirectory) {
            throw FileNotFoundException("expecting a file at $pathValue, instead found a directory")
        }
        FileUtil.createParentDirs(this.file)
    }

    fun exists(): Boolean = file.exists()

    fun delete() {
        if (!file.delete()) {
            throw IllegalStateException("unable to delete $file")
        }
    }

    fun path(): String = pathValue

    @Throws(IOException::class)
    fun write(source: BufferedSource) {
        val tmpFile = File.createTempFile("new", "tmp", file.parentFile)
        var sink: BufferedSink? = null
        try {

            sink = tmpFile.sink().buffer()
            sink.writeAll(source)

            if (!tmpFile.renameTo(file)) {
                throw IOException("unable to move tmp file to " + file.path)
            }
        } catch (e: Exception) {
            throw IOException("unable to write to file", e)
        } finally {
            tmpFile.delete()
            sink?.close()
            source.close()
        }
    }

    @Throws(FileNotFoundException::class)
    fun source(): BufferedSource {
        if (file.exists()) {
            return file.source().buffer()
        }
        throw FileNotFoundException(pathValue)
    }

    fun lastModified(): Long = file.lastModified()
}
