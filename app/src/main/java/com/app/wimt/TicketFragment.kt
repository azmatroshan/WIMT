package com.app.wimt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.wimt.databinding.FragmentTicketBinding

class TicketFragment : Fragment() {
    private lateinit var binding: FragmentTicketBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTicketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}