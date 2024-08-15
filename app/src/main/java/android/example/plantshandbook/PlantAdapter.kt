package android.example.plantshandbook

import android.example.plantshandbook.databinding.PlantItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>(){
    val plantList = ArrayList<Plant>()

    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding) {
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}