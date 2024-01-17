package com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3android2.HomeModel
import com.example.hw3android2.databinding.ItemPanelBinding
import com.example.hw3android2.noteapp.data.local.room.dao.entities.Note

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.NoteViewHolder>() {
    private var homeList = listOf<Note>()

    fun setNoteList(noteList: List<Note>) {
        this.homeList = noteList
    }

    class NoteViewHolder(private val binding: ItemPanelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(HomeModel: Note) {
            binding.tvHave.text = HomeModel.title
            binding.tvWork.text = HomeModel.description

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