package fariborz.com.database.LocalCache

import android.arch.paging.DataSource
import fariborz.com.database.Entities.SearchEntry
import fariborz.com.database.Dao.SearchDao
import java.util.concurrent.Executor

/**
 * Created by Fariborz on 19/03/2020.
 */
class SearchLocalCache(
        private val searchDao: SearchDao,
        private val ioExecutor: Executor
) {

    /**
     * Insert a list of searches in the database, on a background thread.
     */
    fun insert(repos: List<SearchEntry>, insertFinished: ()-> Unit) {
        ioExecutor.execute {
            searchDao.insert(repos)
            insertFinished()
        }
    }

    fun searchesByName(name: String): DataSource.Factory<Int, SearchEntry> {
        // appending '%' so we can allow other characters to be before and after the query string
        val query = "%${name.replace(' ', '%')}%"
        return searchDao.searchesByName(query)
    }
}