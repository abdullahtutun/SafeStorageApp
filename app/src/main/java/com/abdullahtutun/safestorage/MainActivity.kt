package com.abdullahtutun.safestorage

import android.content.Context
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdullahtutun.safestorage.presentation.folder.FolderScreen
import com.abdullahtutun.safestorage.presentation.folder_list.FolderListScreen
import com.abdullahtutun.safestorage.presentation.ui.theme.SafeStorageTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeStorageTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.FolderListScreen.route
                    ){
                        composable(route = Screen.FolderListScreen.route){
                            FolderListScreen(navController)
                        }
                        composable(route = Screen.FolderScreen.route + "/{path}") {
                            FolderScreen()
                        }
                    }
                }
            }
        }


    }

    fun createFile(context: Context, folderName: String) {
        val appFolderPath = Environment.getExternalStorageDirectory().absolutePath + "/SafeStorages/"
        val folderPath = "$appFolderPath$folderName/"

        val folder = File(folderPath)
        if (!folder.exists()) {
            folder.mkdirs()
        }
    }
}
