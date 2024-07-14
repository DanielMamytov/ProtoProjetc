import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3android2.databinding.ItemBinding
import com.example.hw3android2.noteapp.data.local.room.dao.entities.NotePro

class NotesAdapter :
    ListAdapter<NotePro, NotesAdapter.ViewHolder>(DiffUtilCallback()) {

    private var searchQuery: String = ""

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(note: NotePro) = with(binding) {
            title.text = highlightText(note.title, searchQuery)
            description.text = highlightText(note.description, searchQuery)
        }

        private fun highlightText(text: String, query: String): SpannableString {
            val spannableString = SpannableString(text)
            val startIndex = text.lowercase().indexOf(query.lowercase())
            if (startIndex >= 0) {
                val endIndex = startIndex + query.length
                spannableString.setSpan(
                    BackgroundColorSpan(Color.YELLOW),
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            return spannableString
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
        notifyDataSetChanged()
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<NotePro>() {
        override fun areItemsTheSame(oldItem: NotePro, newItem: NotePro): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NotePro, newItem: NotePro): Boolean {
            return oldItem == newItem
        }
    }
}
