package fariborz.com.ViewModelFactory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import fariborz.com.repositories.NowShowingRepository
import fariborz.com.viewmodels.NowShowingViewModel

/**
 * Created by Fariborz on 19/03/2020.
 */
class ViewModelNowShowingFactory(private val repository: NowShowingRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NowShowingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NowShowingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}