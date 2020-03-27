package fariborz.com.database.DatabaseResults

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import fariborz.com.database.Entities.NowShowingEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
data class NowShowingResults(
        val data: LiveData<PagedList<NowShowingEntry>>,
        val networkErrors: LiveData<String>
)