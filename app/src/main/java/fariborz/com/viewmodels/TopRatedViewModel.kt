package fariborz.com.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import fariborz.com.repositories.TopRatedRepository
import fariborz.com.database.DatabaseResults.TopRatedResults
import fariborz.com.database.Entities.TopRatedEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
class TopRatedViewModel(private val repository: TopRatedRepository ) : ViewModel() {

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }

    private val queryLiveData = MutableLiveData<String>()
    private val nowShowingResult: LiveData<TopRatedResults> = Transformations.map(queryLiveData, {
        repository.topRated(it)
    })

    val topRated: LiveData<PagedList<TopRatedEntry>> = Transformations.switchMap(nowShowingResult,
            { it -> it.data })
    val networkErrors: LiveData<String> = Transformations.switchMap(nowShowingResult,
            { it -> it.networkErrors })

    fun getTopRated(region: String) {
        queryLiveData.value = region
    }

}