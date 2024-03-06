package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    private var num1: Int = 0
    private var num2: Int = 0
    private var score: Int = 0

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

        randomNumber()

        binding.btnSubmit.setOnClickListener{
            val answer = binding.txtAnswer.text.toString()
            if (answer.isNotEmpty()) {
                if (answer.toInt() == num1 + num2) {
                    score+=1
                    randomNumber()
                } else {
                    val action = GameFragmentDirections.actionResultFragment(score)
                    Navigation.findNavController(requireView()).navigate(action)
                }
            }
        }
    }
    private fun randomNumber(){
        num1 = Random.nextInt(100)
        num2 = Random.nextInt(100)
        binding.txtQuestion.text = "$num1 + $num2 = ?"
    }
}