package com.abdallah.bibtask.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdallah.bibtask.model.HomeData
import com.denzcoskun.imageslider.models.SlideModel

class HomeViewModel : ViewModel() {



    private val listHomeData = MutableLiveData<List<HomeData>>().apply {
        value = listOf(HomeData("Medical", true),HomeData("Vehicle",false),HomeData("Travel Insurance",false))
    }
    val data: LiveData<List<HomeData>> = listHomeData

    private val list_image = MutableLiveData<ArrayList<SlideModel>>().apply {

        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://brokerage-insurance.com/themes/brokerage/assets/images/logo.png" ))
        imageList.add(SlideModel("https://brokerage-insurance.com/themes/brokerage/assets/images/logo.png" ))
        imageList.add(SlideModel("https://brokerage-insurance.com/themes/brokerage/assets/images/logo.png"))

        value = imageList
    }

    val dataImage: LiveData<ArrayList<SlideModel>> = list_image

}