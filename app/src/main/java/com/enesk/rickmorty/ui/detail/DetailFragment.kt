package com.enesk.rickmorty.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import com.enesk.rickmorty.R
import com.enesk.rickmorty.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel : DetailViewModel by viewModels()
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(args.character.id)
        viewModel.getCharacter(args.character.id!!)
        viewModel.detailResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.apply {
                    tvCharacterName.text = it.name
                    tvCharacterSpecies.text = it.species
                    tvCharacterGender.text = it.gender
                    tvCharacterStatus.text = it.status
                    ivCharacterProfile.load(it.image)

                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}