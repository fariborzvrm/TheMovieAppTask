package fariborz.com.ViewModelFactory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import fariborz.com.repositories.SearchRepository
import fariborz.com.viewmodels.SearchViewModel

/**
 * Created by Fariborz on 19/03/2020.
 */
class ViewModelSearchFactory(private val repository: SearchRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}