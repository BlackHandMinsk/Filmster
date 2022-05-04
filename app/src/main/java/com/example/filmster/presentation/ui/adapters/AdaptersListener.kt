package com.example.filmster.presentation.ui.adapters

import com.example.filmster.model.FilmInfo

interface AdaptersListener {
    fun onClickItem(characterInfo: FilmInfo)
}