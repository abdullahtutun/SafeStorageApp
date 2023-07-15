package com.abdullahtutun.safestorage

sealed class Screen(val route: String) {
    object FolderListScreen: Screen("folder_list_screen")
    object FolderScreen: Screen("folder_screen")
}