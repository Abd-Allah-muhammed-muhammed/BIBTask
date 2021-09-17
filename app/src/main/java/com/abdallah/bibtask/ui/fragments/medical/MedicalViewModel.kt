package com.abdallah.bibtask.ui.fragments.medical

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicalViewModel : ViewModel() {

    private val dataCompany = MutableLiveData<List<String>>().apply {
        value = listOf("Insurance Company *", "AXA Life Egypt", "Royal Insurance")
    }
    val listCompany: LiveData<List<String>> = dataCompany

    private val dataMedical= MutableLiveData<List<String>>().apply {
        value = listOf("Medical Network *", "Test one", "Test Two")
    }
    val listMedical: LiveData<List<String>> = dataMedical

    private val dataGovernorate= MutableLiveData<List<String>>().apply {
        value = listOf("Governorate *", "Alexandria", "Cairo")
    }
    val listGovernorate: LiveData<List<String>> = dataGovernorate

    private val dataCity= MutableLiveData<List<String>>().apply {
        value = listOf("City *", "Mansoura", "Tanta")
    }
    val listCities: LiveData<List<String>> = dataCity

    private val dataProviderType= MutableLiveData<List<String>>().apply {
        value = listOf("Provider Type *", "Hospital", "Pharmacy")
    }
    val listProviderType: LiveData<List<String>> = dataProviderType

    private val dataSpeciality= MutableLiveData<List<String>>().apply {
        value = listOf("Medical Speciality", "Scan", "Optics")
    }
    val listSpeciality: LiveData<List<String>> = dataSpeciality
}