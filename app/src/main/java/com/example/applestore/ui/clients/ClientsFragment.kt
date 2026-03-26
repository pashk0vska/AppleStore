package com.example.applestore.ui.clients

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.applestore.databinding.FragmentClientsBinding

class ClientsFragment : Fragment() {
    private var _binding: FragmentClientsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentClientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}