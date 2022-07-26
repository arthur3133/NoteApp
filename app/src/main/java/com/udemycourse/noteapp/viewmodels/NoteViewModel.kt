package com.udemycourse.noteapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.udemycourse.noteapp.data.NoteSourceData
import com.udemycourse.noteapp.model.Note

class NoteViewModel: ViewModel() {

    private var notesList = mutableStateListOf<Note>()

    init {
        notesList.addAll(NoteSourceData().getNotesList())
    }

    fun getAllNotes(): List<Note> {
        return notesList
    }

    fun addNote(note: Note) {
        notesList.add(note)
    }

    fun removeNote(note: Note) {
        notesList.remove(note)
    }
}