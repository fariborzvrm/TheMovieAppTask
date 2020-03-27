package fariborz.com.database.DatabaseResults

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import fariborz.com.database.Entities.UpcomingEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
data class UpcomingResults(
        val data: LiveData<PagedList<UpcomingEntry>>,
        val networkErrors: LiveData<String>
)