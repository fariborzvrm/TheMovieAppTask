package fariborz.com.ViewModelFactory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import fariborz.com.repositories.TopRatedRepository
import fariborz.com.viewmodels.TopRatedViewModel

/**
 * Created by Fariborz on 19/03/2020.
 */
class ViewModelTopRatedFactory(private val repository: TopRatedRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopRatedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TopRatedViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}