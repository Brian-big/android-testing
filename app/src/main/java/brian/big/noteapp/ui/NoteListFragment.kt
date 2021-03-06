package brian.big.noteapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import brian.big.noteapp.data.NoteDataManager
import brian.big.noteapp.databinding.FragmentNoteListBinding
import brian.big.noteapp.ui.adapters.NoteAdapter

class NoteListFragment : Fragment() {

    private lateinit var binding: FragmentNoteListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        initNotesRv()
        return binding.root

    }

    private fun initNotesRv() {
        val noteAdapter = NoteAdapter(NoteDataManager.notes)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.apply {
            this.layoutManager = layoutManager
            adapter = noteAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabNewNote.setOnClickListener {
            val action =NoteListFragmentDirections.actionFirstFragmentToSecondFragment(null)
            findNavController().navigate(action)
        }
    }
}