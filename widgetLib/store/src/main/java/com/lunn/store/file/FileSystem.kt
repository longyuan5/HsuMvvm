package com.lunn.store.file

import okio.BufferedSource
import java.io.FileNotFoundException
import java.io.IOException
import kotlin.time.Duration
import kotlin.time.ExperimentalTime


interface FileSystem {

    /**
     * read the latest version of a file
     *
     * @param path what to read
     * @return a [BufferedSource] to read - Caller must close it!
     * @throws FileNotFoundException
     */
    @Throws(FileNotFoundException::class)
    fun read(path: String): BufferedSource

    /**
     * write a new version of a file. No readers will "see" this version until it has successfully been completely
     * written to and closed. In case of error, the version is deleted from disk.
     *
     * @param path what to write to
     * @param source a [BufferedSource] containing the content to be written to disk. Caller must close it!
     * @throws IOException
     */
    @Throws(IOException::class)
    fun write(path: String, source: BufferedSource)

    /**
     * delete a single file. The file data won't *really* be deleted until all readers are done reading.
     *
     * @param path what to delete - must correspond to a single file, not a directory
     * @throws IOException
     */
    @Throws(IOException::class)
    fun delete(path: String)

    /**
     * delete a directory, recursively.
     * The files' data won't *really* be deleted until all readers are done reading.
     *
     * @param path what to delete - must correspond to a directory, not a single file
     * @throws IOException
     */
    @Throws(IOException::class)
    fun deleteAll(path: String)

    /**
     * list all files under a given directory, recursively.
     */
    @Throws(FileNotFoundException::class)
    fun list(path: String): Collection<String>

    /**
     * does this file exist?
     *
     * @param file what to test for
     * @return exists, duh
     */
    fun exists(file: String): Boolean

    /**
     * compares age of file with given expiration time and returns
     * appropriate recordState
     */
    @ExperimentalTime
    fun getRecordState(
        expirationDuration: Duration,
        path: String
    ): RecordState
}
