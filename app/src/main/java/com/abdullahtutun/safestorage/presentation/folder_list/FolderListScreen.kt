package com.abdullahtutun.safestorage.presentation.folder_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
@Composable
fun FolderListScreen(
    navController: NavController,
    viewModel: FolderListViewModel = hiltViewModel()
){
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items()
        }
    }

}