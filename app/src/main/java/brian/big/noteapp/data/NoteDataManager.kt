package brian.big.noteapp.data

import brian.big.noteapp.model.Note

object NoteDataManager {
    val notes = mutableListOf<Note>()
    private val str = "lorem ipsum .. always note something"
    init {
        initSampleNotes()
    }

    private fun initSampleNotes() {
        for (i in 1..25){
            when {
                i % 7 == 0 -> notes.add(Note("morning note $i", str))
                i % 5 == 0 -> notes.add(Note("mid morning note $i", str))
                i % 4 == 0 -> notes.add(Note("evening note $i", str))
                i % 3 == 0 -> notes.add(Note("midday note $i", str))
                i % 2 == 0 -> notes.add(Note("mid evening note $i", str))
                else -> notes.add(Note("night note $i", str))
            }
        }
    }
    fun addNote(note: Note){
        notes.add(note)
    }
    fun editNote(position: Int, note: Note){
        val note1 = notes[position]
        note1.apply {
            title = note.title
            content = note.content
        }
    }
    fun getNote(position: Int): Note{
        return notes[position]
    }
}