package fariborz.com.database.DatabaseResults

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import fariborz.com.database.Entities.TopRatedEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
data class TopRatedResults(
        val data: LiveData<PagedList<TopRatedEntry>>,
        val networkErrors: LiveData<String>
)