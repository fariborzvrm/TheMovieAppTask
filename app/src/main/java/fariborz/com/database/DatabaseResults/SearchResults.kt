package fariborz.com.database.DatabaseResults

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import fariborz.com.database.Entities.SearchEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
data class SearchResults(
        val data: LiveData<PagedList<SearchEntry>>,
        val networkErrors: LiveData<String>
)