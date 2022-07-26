package com.udemycourse.noteapp.data

import com.udemycourse.noteapp.model.Note

class NoteSourceData {
    fun getNotesList(): List<Note> {
        return listOf(
            Note(title = "Movie Time", description = "Watch movie with family"),
            Note(title = "Lunch", description = "Take lunch at 12"),
            Note(title = "Play Game", description = "Play pubg at noon"),
            Note(title = "YT video", description = "Watch youtube at evening"),
            Note(title = "Tea Break", description = "take tea with family"),
            Note(title = "Dinner", description = "Take dinner at 8"),
            Note(title = "Movie Time", description = "Watch movie with family"),
            Note(title = "Movie Time", description = "Watch movie with family"),
        )
    }
}