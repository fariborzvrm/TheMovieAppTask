package fariborz.com.database.DatabaseResults

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import fariborz.com.database.Entities.PopularEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
data class PopularResults(
        val data: LiveData<PagedList<PopularEntry>>,
        val networkErrors: LiveData<String>
)