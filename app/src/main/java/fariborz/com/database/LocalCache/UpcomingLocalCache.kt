package fariborz.com.database.LocalCache

import android.arch.paging.DataSource
import fariborz.com.database.Dao.UpcomingDao
import java.util.concurrent.Executor
import fariborz.com.database.Entities.UpcomingEntry
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by Fariborz on 19/03/2020.
 */
class UpcomingLocalCache(
        private val upcomingDao: UpcomingDao,
        private val ioExecutor: Executor
) {

    /**
     * Insert a list of searches in the database, on a background thread.
     */
    fun insert(repos: List<UpcomingEntry>, insertFinished: ()-> Unit) {
        ioExecutor.execute {
            upcomingDao.insert(repos)
            insertFinished()
        }
    }

    fun getAllUpcoming(): DataSource.Factory<Int, UpcomingEntry> {
        return upcomingDao.loadAllUpcoming()
    }

    fun getAllItemsInUpcoming(): Int {
        val data  = runBlocking {
            async(CommonPool) {
                val numItems = upcomingDao.getNumberOfRows()
                return@async numItems
            }.await()
        }
        return data

    }

}