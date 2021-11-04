package brian.big.noteapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import brian.big.noteapp.R
import brian.big.noteapp.model.Note
import brian.big.noteapp.ui.NoteListFragmentDirections

class NoteAdapter(private val notes: List<Note>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var pos = 0
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvContent: TextView = view.findViewById(R.id.tvContent)
        init {
            view.setOnClickListener {
                val action = NoteListFragmentDirections.actionFirstFragmentToSecondFragment(pos.toString())
                view.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.apply {
            pos = position
            tvTitle.text = note.title
            tvContent.text = note.content
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}