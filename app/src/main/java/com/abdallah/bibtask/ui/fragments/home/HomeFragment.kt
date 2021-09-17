package com.abdallah.bibtask.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdallah.bibtask.adpter.HomAdapter
import com.abdallah.bibtask.databinding.FragmentHomeBinding
import java.util.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeAdapter:HomAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUpRecyclerHome()
        setUpSlider()
        return root
    }

    private fun setUpSlider() {
        homeViewModel.dataImage.observe(viewLifecycleOwner, Observer {
            binding.imageSlider.setImageList(it)
        })
    }

    private fun setUpRecyclerHome() {
        homeAdapter = HomAdapter()
        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rcHome.layoutManager = mLayoutManager
        binding.rcHome.itemAnimator = DefaultItemAnimator()
        getData()

    }

    private fun getData() {

        homeViewModel.data.observe(viewLifecycleOwner, {
            homeAdapter.setList(it)
        })

        binding.rcHome.adapter = homeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}