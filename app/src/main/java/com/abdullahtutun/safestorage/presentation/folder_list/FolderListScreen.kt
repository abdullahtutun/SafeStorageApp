package com.abdullahtutun.safestorage.presentation.folder_list

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.ImeAction
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.abdullahtutun.safestorage.Screen
import com.abdullahtutun.safestorage.data.FileManager
import com.abdullahtutun.safestorage.presentation.folder_list.component.FolderListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FolderListScreen(
    navController: NavController,
    viewModel: FolderListViewModel = hiltViewModel(),
    context: Context = LocalContext.current
){
    val state = viewModel.state.value
    var isDialogVisible by remember {
        mutableStateOf(false)
    }
    var inputFolderName by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current

    Scaffold(
        content = { innerPadding ->
            LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding) ) {
                items(state.folders) { folder ->
                    FolderListItem(folder = folder, onItemClick = {
                        navController.navigate(Screen.FolderScreen.route+"/${folder.path}")
                    })
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isDialogVisible = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    )

    if (isDialogVisible) {
        AlertDialog(
            onDismissRequest = {
                isDialogVisible = false
                inputFolderName = ""
            },
            title = { Text("Klasör Oluştur") },
            text = {
                TextField(
                    value = inputFolderName,
                    onValueChange = { inputFolderName = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            isDialogVisible = false
                        }
                    )
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        FileManager.createFile(inputFolderName)
                        isDialogVisible = false
                        inputFolderName = ""
                    }
                ) {
                    Text("Onayla")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isDialogVisible = false
                        inputFolderName = ""
                    }
                ) {
                    Text("İptal")
                }
            }
        )
    }

}