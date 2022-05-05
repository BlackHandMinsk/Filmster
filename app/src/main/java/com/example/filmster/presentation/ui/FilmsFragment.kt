package com.example.filmster.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController


import androidx.paging.LoadState
import com.example.filmster.R
import com.example.filmster.databinding.FragmentFilmsBinding


import com.example.filmster.presentation.ui.adapters.FilmAdapter
import com.example.filmster.presentation.ui.adapters.FilmLoaderStateAdapter
import com.example.filmster.presentation.ui.viewmodels.FilmViewModel
import com.google.android.material.snackbar.Snackbar

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class FilmsFragment : Fragment() {
    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FilmViewModel by viewModels()

    @Inject
    lateinit var filmAdapter: FilmAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            rvFilms.adapter = filmAdapter.withLoadStateFooter(
                footer = FilmLoaderStateAdapter { filmAdapter.retry() }
            )
            swipeRefresh.setOnRefreshListener {
                filmAdapter.retry()
                swipeRefresh.isRefreshing = false
            }
        }

        lifecycleScope.launch {
            viewModel.films.collectLatest(filmAdapter::submitData)
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            filmAdapter.loadStateFlow.collectLatest { loadState ->
                val isListEmpty =
                    loadState.refresh is LoadState.NotLoading && filmAdapter.itemCount == 0

                binding.rvFilms.isVisible = !isListEmpty
                binding.tvErrorMessage.isVisible = filmAdapter.itemCount == 0
                binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                val errorState = loadState.source.append as? LoadState.Error
                    ?: loadState.source.prepend as? LoadState.Error
                    ?: loadState.append as? LoadState.Error
                    ?: loadState.prepend as? LoadState.Error
                errorState?.let {
                    Snackbar.make(
                        binding.root,
                        requireContext().getString(R.string.message_internet_connecton_error),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}