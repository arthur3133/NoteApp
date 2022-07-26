package com.udemycourse.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.udemycourse.noteapp.screens.NoteScreen
import com.udemycourse.noteapp.ui.theme.NoteAppTheme
import com.udemycourse.noteapp.viewmodels.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NoteScreen(
                        notesList = noteViewModel.getAllNotes(),
                        addNote = {
                            noteViewModel.addNote(it)
                        },
                        removeNote = {
                            noteViewModel.removeNote(it)
                        }
                    )
                }
            }
        }
    }
}