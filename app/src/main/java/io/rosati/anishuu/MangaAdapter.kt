package io.rosati.anishuu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import io.rosati.anishuu.db.manga.Manga
import io.rosati.anishuu.MangaAdapter.MangaViewHolder

class MangaAdapter : ListAdapter<Manga, MangaViewHolder>(MangaComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): MangaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.manga_adapter_item, parent, false)
                return MangaViewHolder(view)
            }
        }
    }

    class MangaComparator : DiffUtil.ItemCallback<Manga>() {
        override fun areItemsTheSame(oldItem: Manga, newItem: Manga): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Manga, newItem: Manga): Boolean {
            return oldItem.word == newItem.word
        }
    }
}