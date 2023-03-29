package com.ab.hilt_kt.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ab.hilt_kt.R
import com.ab.hilt_kt.databinding.FragmentFIrstBinding
import com.ab.hilt_kt.ui.viewmodels.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFrag : Fragment() {
    private lateinit var bind: FragmentFIrstBinding
    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentFIrstBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(this@FirstFrag)[FirstViewModel::class.java]

        viewModel.fetchDogs()

        viewModel.list.observe(requireActivity()) {
            Toast.makeText(
                requireContext(),
                "Its from First ViewModel ${it.message}",
                Toast.LENGTH_SHORT
            ).show()
        }

        bind.click.setOnClickListener {
            findNavController().navigate(R.id.action_FIrstFrag_to_secondFrag)
        }
        return bind.root
    }
}