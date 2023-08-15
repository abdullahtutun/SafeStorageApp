package com.abdullahtutun.safestorage.presentation.folder_list

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Environment
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abdullahtutun.safestorage.MainActivity
import com.abdullahtutun.safestorage.data.FileManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import javax.inject.Inject

@HiltViewModel
class FolderListViewModel @Inject constructor(
): ViewModel() {

    private val _state = mutableStateOf(FolderListState())
    val state: State<FolderListState> = _state

}