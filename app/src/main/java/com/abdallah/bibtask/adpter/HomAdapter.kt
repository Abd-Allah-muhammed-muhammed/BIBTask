package com.abdallah.bibtask.adpter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdallah.bibtask.R
import com.abdallah.bibtask.model.HomeData
import com.abdallah.bibtask.databinding.ItemHomeBinding

class HomAdapter() : RecyclerView.Adapter<HomAdapter.ViewHolder>() {

    private lateinit var items: List<HomeData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {

            val homeData = items[position]
            binding.tvTitle.text = homeData.title

            if (homeData.isActive){

                binding.tvComingSoon.visibility = View.GONE
            }else{
                binding.tvComingSoon.visibility = View.VISIBLE
            }

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemHomeBinding.bind(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList (items :List<HomeData>){
        this.items = items
        notifyDataSetChanged()
    }

}

