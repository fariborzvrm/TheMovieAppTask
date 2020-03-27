package fariborz.com.repositories

import android.arch.paging.LivePagedListBuilder
import fariborz.com.boundaryCallbacks.UpcomingBoundaryCallback
import fariborz.com.database.DatabaseResults.UpcomingResults
import fariborz.com.database.LocalCache.UpcomingLocalCache
import fariborz.com.network.NetworkService

/**
 * Created by Fariborz on 19/03/2020.
 */
class UpcomingRepository(
        private val service: NetworkService,
        private val upcomingCache: UpcomingLocalCache
) {


    /**
     * Search repositories whose names match the query.
     */
    fun upcoming(region: String): UpcomingResults {
        val dataSourceFactory = upcomingCache.getAllUpcoming()

        val boundaryCallback = UpcomingBoundaryCallback(region, service, upcomingCache)
        val networkErrors = boundaryCallback.networkErrors
        // Get the paged list
        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
                .setBoundaryCallback(boundaryCallback)
                .build()
        // Get data from the local cache
        return UpcomingResults(data, networkErrors)
    }



    companion object {
        private const val NETWORK_PAGE_SIZE = 50
        private const val DATABASE_PAGE_SIZE = 60
    }

}