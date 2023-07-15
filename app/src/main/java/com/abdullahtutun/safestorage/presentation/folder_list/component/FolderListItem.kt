package com.abdullahtutun.safestorage.presentation.folder_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.abdullahtutun.safestorage.domain.model.Folder

@Composable
fun FolderListItem(
    folder: Folder,
    onItemClick: (Folder) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(folder) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = folder.name,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }

}