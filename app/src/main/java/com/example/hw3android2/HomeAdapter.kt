package com.example.hw3android2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3android2.databinding.ItemPanelBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.NoteViewHolder>() {
    private var homeList = mutableListOf<HomeModel>()

    fun setNoteList(noteList: MutableList<HomeModel>) {
        this.homeList = noteList
    }

    class NoteViewHolder(private val binding: ItemPanelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(HomeModel: HomeModel) {
            binding.tvHave.text = HomeModel.title
            binding.tvDataTime.text = HomeModel.data
            binding.tvWork.text = HomeModel.note


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemPanelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(homeList[position])
    }
}