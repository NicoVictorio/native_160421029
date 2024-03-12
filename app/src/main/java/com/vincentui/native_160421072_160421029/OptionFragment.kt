package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vincentui.native_160421072_160421029.databinding.ActivityMainBinding
import com.vincentui.native_160421072_160421029.databinding.FragmentOptionBinding

class OptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOptionBinding
    private val level = arrayOf("Easy", "Medium", "Hard")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            level)
        binding.txtLevel.setAdapter(adapter)
    }
}