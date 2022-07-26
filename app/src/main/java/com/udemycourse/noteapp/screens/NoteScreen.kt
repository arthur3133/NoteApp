package com.udemycourse.noteapp.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udemycourse.noteapp.R
import com.udemycourse.noteapp.components.NoteButton
import com.udemycourse.noteapp.components.NoteInputField
import com.udemycourse.noteapp.data.NoteSourceData
import com.udemycourse.noteapp.model.Note

@Composable
fun NoteScreen(
    notesList: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            backgroundColor = Color(0xFFACAAAA),
            actions = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications Icon")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputField(
                value = title,
                onValueChanged = { title = it },
                label = "Title"
            )
            NoteInputField(
                value = description,
                onValueChanged = { description = it },
                label = "Add a note"
            )
            NoteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                      addNote(Note(
                          title = title,
                          description = description
                      ))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note Added!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            LazyColumn {
                items(notesList) { note ->
                    NoteRow(note = note, onClick = {
                        removeNote(it)
                    })
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    note: Note,
    onClick: (Note) -> Unit
) {
   Card(
       modifier = Modifier
           .fillMaxWidth()
           .padding(4.dp)
           .clickable { onClick(note) },
       backgroundColor = Color(0xFFACAAAA),
       shape = RoundedCornerShape(topEnd = 15.dp, bottomStart = 15.dp),
       elevation = 4.dp
   ) {
       Column(
           modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
           horizontalAlignment = Alignment.Start
       ) {
           Text(
               text = note.title,
               style = MaterialTheme.typography.subtitle2
           )
           Text(
               text = note.description,
               style = MaterialTheme.typography.subtitle1
           )
       }
   }
}