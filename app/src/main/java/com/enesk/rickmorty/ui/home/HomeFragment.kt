package com.enesk.rickmorty.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.enesk.rickmorty.R
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.databinding.FragmentHomeBinding
import com.enesk.rickmorty.ui.bottom_sheet.FilterBottomSheetFragment
import com.enesk.rickmorty.ui.home.adapter.HomeRecyclerAdapter
import com.enesk.rickmorty.ui.home.listener.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeRecyclerAdapter
    private lateinit var bottomSheet : FilterBottomSheetFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomSheet = FilterBottomSheetFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCharacterRecyclerView()
        observe()

        binding.mainFragmentFab.setOnClickListener {
            bottomSheet.show(parentFragmentManager,"FILTER")
        }
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
        homeAdapter = HomeRecyclerAdapter(object : ItemClickListener{
            override fun onItemClick(character: Character) {
                val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(character)
                findNavController().navigate(action)
                println(character.id)
            }
        })

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