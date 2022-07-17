package com.enesk.rickmorty.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.enesk.rickmorty.R
import com.enesk.rickmorty.databinding.FragmentHomeBinding
import com.enesk.rickmorty.ui.home.adapter.HomeRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeViewModel by viewModels()

    private lateinit var homeAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel.getdata(1)
        setupCharacterRecyclerView()
        observe()
    }

    private fun observe(){
        //viewModel.characterList.observe(viewLifecycleOwner, Observer {
        //    it?.let {
        //        binding.characterRecyclerView.visibility = View.VISIBLE
        //        countryAdapter.diffList = it.results!!
        //    }
        //})
        lifecycleScope.launchWhenCreated {
            viewModel.getList().collectLatest {
                homeAdapter.submitData(it)
            }

        }

    }

    private fun setupCharacterRecyclerView(){
        homeAdapter = HomeRecyclerAdapter()
        binding.characterRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = homeAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}