package fariborz.com.ViewModelFactory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import fariborz.com.repositories.PopularRepository
import fariborz.com.viewmodels.PopularViewModel

/**
 * Created by Fariborz on 19/03/2020.
 */
class ViewModelPopularFactory(private val repository: PopularRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PopularViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}