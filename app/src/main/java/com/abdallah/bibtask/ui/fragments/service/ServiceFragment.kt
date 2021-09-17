package com.abdallah.bibtask.ui.fragments.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdallah.bibtask.adpter.HomAdapter
import com.abdallah.bibtask.databinding.FragmentServiceBinding

class ServiceFragment : Fragment() {

    private lateinit var serviceViewModel: ServiceViewModel
    private var _binding: FragmentServiceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        serviceViewModel =
            ViewModelProvider(this).get(ServiceViewModel::class.java)

        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUpRecyclerService()

        return root
    }



    private fun setUpRecyclerService() {

        val homeAdapter = HomAdapter()

        val mLayoutManager = GridLayoutManager(context,3)

        binding.rcService.layoutManager = mLayoutManager
        binding.rcService.itemAnimator = DefaultItemAnimator()

        serviceViewModel.data.observe(viewLifecycleOwner, Observer {

            homeAdapter.setList(it)
        })

        binding.rcService.adapter = homeAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}