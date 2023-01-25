package com.example.activityviewmo.ui.fragments.firstfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.activityviewmo.R
import com.example.activityviewmo.databinding.FragmentFirstBinding
import com.example.activityviewmo.ui.adapter.NotesAdapter

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel by activityViewModels<FirstViewModel>()
    private var notesAdapter = NotesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        navigations()
        setupClick()
    }

    private fun onClick() {
        binding.rvList.adapter = notesAdapter
    }

    private fun navigations() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addFragment)
        }
    }

    private fun setupClick() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
        }
    }
}