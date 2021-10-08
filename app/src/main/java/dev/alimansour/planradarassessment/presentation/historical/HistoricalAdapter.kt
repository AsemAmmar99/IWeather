package dev.alimansour.planradarassessment.presentation.historical

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.alimansour.planradarassessment.databinding.ItemHistoricalBinding
import dev.alimansour.planradarassessment.domain.model.HistoricalData
import dev.alimansour.planradarassessment.presentation.details.DetailsActivity

/**
 * WeatherApp Android Application developed by: Ali Mansour
 * ----------------- WeatherApp IS FREE SOFTWARE -------------------
 * https://www.alimansour.dev   |   mailto:dev.ali.mansour@gmail.com
 */
class HistoricalAdapter(private val list: List<HistoricalData?>) :
    RecyclerView.Adapter<HistoricalAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding: ItemHistoricalBinding = ItemHistoricalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        try {
            val historicalData = list[position]
            holder.binding.data = historicalData

            holder.itemView.setOnClickListener {
                val intent = Intent(it.context, DetailsActivity::class.java)
                intent.putExtra("data", historicalData)
                it.context.startActivity(intent)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AccountViewHolder(val binding: ItemHistoricalBinding) :
        RecyclerView.ViewHolder(binding.root)
}