package com.example.filmster.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.filmster.databinding.ItemFilmBinding
import com.example.filmster.domain.model.FilmInfo
import javax.inject.Inject

class FilmAdapter @Inject constructor(
    private val glide: RequestManager
) : PagingDataAdapter<FilmInfo, FilmAdapter.FilmViewHolder>(CharactersDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(layoutInflater, parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(getItem(holder.bindingAdapterPosition)!!)
    }

    private object CharactersDiffCallback : DiffUtil.ItemCallback<FilmInfo>() {

        override fun areItemsTheSame(oldItem: FilmInfo, newItem: FilmInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FilmInfo, newItem: FilmInfo): Boolean {
            return oldItem == newItem
        }
    }

    inner class FilmViewHolder(
        private val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(filmInfo: FilmInfo) {
            val image = filmInfo.multimedia

            glide.load(image)
                .fitCenter()
                .into(binding.ivFilmLogo)

            binding.apply {
                filmInfo.let { info ->
                    tvDisplayTittle.text = info.display_title
                    tvOpeningDate.text = info.opening_date
                    tvMpaaRating.text = info.mpaa_rating
                    tvHeadLine.text = info.summary_short
                }
            }

        }
    }
}