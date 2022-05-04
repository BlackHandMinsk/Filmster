package com.example.filmster.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmster.domain.GetRemoteListFilmsUseCase
import com.example.filmster.model.FilmInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val getRemoteListFilmsUseCase: GetRemoteListFilmsUseCase
) : ViewModel() {

    private val _films = getRemoteListFilmsUseCase.invoke()
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
    val films: StateFlow<PagingData<FilmInfo>>
        get() = _films
}