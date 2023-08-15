package com.abdullahtutun.safestorage.data

import android.os.Environment
import android.util.Log
import java.io.File

object FileManager {

    fun createFile(folderName: String) {
        Log.d("aaaa",Environment.getExternalStorageDirectory().absolutePath )
        val appFolderPath = Environment.getExternalStorageDirectory().absolutePath + "/SafeStorage/"
        val folderPath = "$appFolderPath$folderName/"

        val folder = File(folderPath)
        if (!folder.exists()) {
            folder.mkdirs()
        }
    }
}