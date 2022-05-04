package com.example.filmster.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager

import com.example.filmster.databinding.ItemFilmBinding
import com.example.filmster.model.FilmInfo
import javax.inject.Inject

class FilmAdapter @Inject constructor(
    private val glide: RequestManager
) : PagingDataAdapter<FilmInfo, FilmAdapter.FilmViewHolder>(CharactersDiffCallback) {
    private var listener: AdaptersListener? = null

    fun setOnClickListener(onClickListener: AdaptersListener) {
        this.listener = onClickListener
    }

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
            return oldItem.summary_short == newItem.summary_short
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
                    tvHeadline.text = info.headline
                    tvDisplayTittle.text = info.display_title
                    tvSummaryShort.text = info.summary_short
                }
            }
            initButtonsListeners(filmInfo)
        }

        private fun initButtonsListeners(filmInfo: FilmInfo?) {
            binding.filmItem.setOnClickListener {
                filmInfo?.let { characterInfo -> listener?.onClickItem(characterInfo) }
            }
        }
    }
}