package com.app.wimt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.wimt.databinding.FragmentPnrBinding

class PnrFragment : Fragment() {
    private lateinit var binding: FragmentPnrBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPnrBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}