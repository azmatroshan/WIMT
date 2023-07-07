package com.app.wimt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.wimt.databinding.FragmentSpotBinding

class SpotFragment : Fragment() {
    private lateinit var binding: FragmentSpotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSpotBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}