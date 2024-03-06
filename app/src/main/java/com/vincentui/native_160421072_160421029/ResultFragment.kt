package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentGameBinding
import com.vincentui.native_160421072_160421029.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val score = ResultFragmentArgs.fromBundle(requireArguments()).finalScore
            binding.txtScore.text = "Your score is $score"
        }

        binding.btnMain.setOnClickListener{
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
    }
}