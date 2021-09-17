package com.abdallah.bibtask.ui.fragments.medical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abdallah.bibtask.R
import com.abdallah.bibtask.databinding.FragmentMedicalBinding

class MedicalFragment : Fragment() {

    private lateinit var medicalViewModel: MedicalViewModel
    private var _binding: FragmentMedicalBinding? = null

    private var isCompanySelected = false
    private var isMedicalSelected = false
    private var isGovernorateSelected = false
    private var isCitySelected = false
    private var isProviderSelected = false
    private var isSpecialitySelected = false


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicalViewModel =
            ViewModelProvider(this).get(MedicalViewModel::class.java)

        _binding = FragmentMedicalBinding.inflate(inflater, container, false)
        val root: View = binding.root



        getDataCompany()
        getDataSpeciality()
        getDataProviderType()
        getDataGovernorate()
        getDataCities()
        getDataMedicalNetwork()
        clicks()

        return root
    }

    private fun clicks() {

        binding.btnFind.setOnClickListener {

            validate()
        }
    }

    private fun validate() {

        if (!isCompanySelected) {

            Toast.makeText(context, getString(R.string.select_company), Toast.LENGTH_SHORT).show()
        } else if (!isMedicalSelected) {

            Toast.makeText(context, getString(R.string.select_media), Toast.LENGTH_SHORT).show()
        } else if (!isGovernorateSelected) {
            Toast.makeText(context, getString(R.string.select_governorate), Toast.LENGTH_SHORT).show()

        } else if (!isCitySelected) {

            Toast.makeText(context, getString(R.string.select_city), Toast.LENGTH_SHORT).show()
        } else if (!isProviderSelected) {

            Toast.makeText(context, getString(R.string.select_provider_type), Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(context, getString(R.string.done), Toast.LENGTH_SHORT).show()
        }

    }


    private fun getDataCompany() {

        medicalViewModel.listCompany.observe(viewLifecycleOwner, Observer {

            val aa = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spCompany.setAdapter(aa)
            binding.spCompany.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ) {

                    isCompanySelected = position != 0

                }

            }
        })

    }

    private fun getDataGovernorate() {


        medicalViewModel.listGovernorate.observe(viewLifecycleOwner, Observer {

            val aa = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spGovernorate.setAdapter(aa)
            binding.spGovernorate.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    isGovernorateSelected = position != 0

                }

            }
        })

    }

    private fun getDataMedicalNetwork() {


        medicalViewModel.listMedical.observe(viewLifecycleOwner, Observer {

            val aa = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spMedical.setAdapter(aa)
            binding.spMedical.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    isMedicalSelected = position != 0
                }

            }
        })


    }

    private fun getDataCities() {

        medicalViewModel.listCities.observe(viewLifecycleOwner, Observer {

            val aa = ArrayAdapter(requireContext(),android. R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spCity.setAdapter(aa)
            binding.spCity.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {


                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    isCitySelected = position != 0

                }

            }
        })

    }

    private fun getDataProviderType() {

        medicalViewModel.listProviderType.observe(viewLifecycleOwner, Observer {

            val aa = ArrayAdapter(requireContext(),android. R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spProvider.setAdapter(aa)
            binding.spProvider.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    isProviderSelected = position != 0

                }

            }
        })

    }

    private fun getDataSpeciality() {
        medicalViewModel.listSpeciality.observe(viewLifecycleOwner, Observer {
            val aa = ArrayAdapter(requireContext(),android. R.layout.simple_spinner_item, it)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            binding.spSpeciality.setAdapter(aa)
            binding.spSpeciality.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    isSpecialitySelected = position != 0

                }

            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}