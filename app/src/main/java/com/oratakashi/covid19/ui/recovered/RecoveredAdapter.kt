package com.oratakashi.covid19.ui.recovered

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.covid19.R
import com.oratakashi.covid19.data.model.recovered.DataRecovered
import com.oratakashi.covid19.ui.main.MainInterfaces
import kotlinx.android.synthetic.main.adapter_list.view.*

class RecoveredAdapter(
    val data : List<DataRecovered>, val parent : MainInterfaces
) : RecyclerView.Adapter<RecoveredAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list,
            parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvCountry.text = when(data[position].provinceState!=null){
            true -> {
                "${data[position].provinceState}, ${data[position].countryRegion}"
            }
            false -> {
                "${data[position].countryRegion}"
            }
        }
        holder.itemView.tvConfirmed.text = "Confirmed : ${data[position].confirmed} Orang"
        holder.itemView.tvRecovered.text = "Recovered : ${data[position].recovered} Orang"
        holder.itemView.tvDeath.text = "Deaths : ${data[position].deaths} Orang"
        holder.itemView.llAdapter.setOnClickListener {
            parent.getLocation(data[position].lat!!.toDouble(), data[position].long!!.toDouble())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}