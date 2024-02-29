package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$name's Turn"
        }

        binding.btnBack.setOnClickListener{
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}