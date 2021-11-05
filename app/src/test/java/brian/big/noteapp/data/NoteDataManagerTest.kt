package brian.big.noteapp.data

import brian.big.noteapp.model.Note
import org.junit.Assert.*

class NoteDataManagerTest {

    @org.junit.Test
    fun addNote() {
        val title = "test Note"
        val content = "this is a test note"
        val note = Note(title, content)
        NoteDataManager.addNote(note)
    }

}