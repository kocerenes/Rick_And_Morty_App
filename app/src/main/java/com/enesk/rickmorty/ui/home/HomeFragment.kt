package com.enesk.rickmorty.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.enesk.rickmorty.R
import com.enesk.rickmorty.databinding.FragmentHomeBinding
import com.enesk.rickmorty.ui.home.adapter.HomeRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : HomeViewModel

    private val countryAdapter = HomeRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        //initViews()
        setupCharacterRecyclerView()
        viewModel.getData(1)
        observe()
    }

    private fun observe(){
        viewModel.characterList.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.characterRecyclerView.visibility = View.VISIBLE
                countryAdapter.diffList = it.results!!
            }
        })
    }

    private fun initViews() = with(binding){
        characterRecyclerView.adapter = countryAdapter
    }

    private fun setupCharacterRecyclerView() {
        binding.characterRecyclerView.adapter = countryAdapter

            binding.characterRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = countryAdapter
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}