package com.abdullahtutun.safestorage.presentation.folder_list

import com.abdullahtutun.safestorage.domain.model.Folder

data class FolderListState(
    val isLoading: Boolean = false,
    val folders: List<Folder> = emptyList(),
    val error: String = ""
)