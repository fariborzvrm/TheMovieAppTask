package fariborz.com.ViewModelFactory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import fariborz.com.repositories.UpcomingRepository
import fariborz.com.viewmodels.UpcomingViewModel

/**
 * Created by Fariborz on 19/03/2020.
 */
class ViewModelUpcomingFactory(private val repository: UpcomingRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpcomingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UpcomingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}