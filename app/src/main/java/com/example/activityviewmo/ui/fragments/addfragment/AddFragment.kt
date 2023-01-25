package com.example.activityviewmo.ui.fragments.addfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.activityviewmo.databinding.FragmentAddBinding
import com.example.activityviewmo.ui.fragments.firstfragment.FirstViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel by activityViewModels<FirstViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }
    private fun onClick() {
        binding.btnSave.setOnClickListener{
            val number = binding.edName.text.toString().trim()
            val title = binding.edAge.text.toString()
            val description = binding.edEmail.text.toString().trim()

            viewModel.addNote(number = number, title = title, description = description)
            findNavController().navigateUp()
        }
    }
}