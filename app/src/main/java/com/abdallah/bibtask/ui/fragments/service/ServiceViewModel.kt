package com.abdallah.bibtask.ui.fragments.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdallah.bibtask.model.HomeData

class ServiceViewModel : ViewModel() {


    private val listHomeData = MutableLiveData<List<HomeData>>().apply {
        value = listOf(
            HomeData("Vehicle Insurance", false),
            HomeData("Home Insurance",false),
            HomeData("Life Insurance Individual",false),
            HomeData("Travel Insurance",false),
            HomeData("Medical Insurance",true),
            HomeData("Critical Illness Insurance",false),
            HomeData("Personal Accident",false),
            HomeData("Marine & Air Insurance",false),
            HomeData("Inland Insurance",false),
            HomeData("Yacht Insurance",false),
            
        )
    }
    val data: LiveData<List<HomeData>> = listHomeData
}