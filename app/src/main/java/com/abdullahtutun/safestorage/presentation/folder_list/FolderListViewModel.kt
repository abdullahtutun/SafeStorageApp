package com.abdullahtutun.safestorage.presentation.folder_list

import android.content.Context.MODE_PRIVATE
import android.os.Environment
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abdullahtutun.safestorage.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import javax.inject.Inject

@HiltViewModel
class FolderListViewModel @Inject constructor(

): ViewModel() {

    private val _state = mutableStateOf(FolderListState())
    val state: State<FolderListState> = _state

    fun createFile(fileName: String) {
        /*val appFolderPath = Environment.getExternalStorageDirectory().absolutePath + "/SafeStorages/"
        val folderPath = "$appFolderPath$folderName/"

        val folder = File(folderPath)
        if (!folder.exists()) {
            folder.mkdirs()
        }*/

        var fos: FileOutputStream = openFileOutput(fileName, MODE_PRIVATE)
        var yazici: OutputStreamWriter = OutputStreamWriter(fos)
        yazici.write("abdullah")
        yazici.close()

    }
}