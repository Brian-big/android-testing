package brian.big.noteapp.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import brian.big.noteapp.R
import brian.big.noteapp.data.NoteDataManager
import brian.big.noteapp.databinding.FragmentEditNoteBinding
import brian.big.noteapp.model.Note

class EditNoteFragment : Fragment() {
    private val args: EditNoteFragmentArgs by navArgs()

    private lateinit var binding: FragmentEditNoteBinding
    private lateinit var note: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        if (args.notePosition != null){
            val pos = args.notePosition!!.toInt()
            note = NoteDataManager.getNote(pos)
            binding.apply {
                etTitle.setText(note.title)
                etContent.setText(note.content)
                buttonSecond.text = getString(R.string.save_changes)
            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            if (!TextUtils.isEmpty(binding.etTitle.text) &&
                !TextUtils.isEmpty(binding.etContent.text)){
                    save()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }

    private fun save() {
        if (args.notePosition == null){
                note = Note(binding.etTitle.text.toString(),
                    binding.etContent.text.toString())
                NoteDataManager.addNote(note)
            }
        else{
            val newNote = Note(binding.etTitle.text.toString(), binding.etContent.text.toString())
            NoteDataManager.editNote(args.notePosition!!.toInt(),newNote )
        }

    }
}