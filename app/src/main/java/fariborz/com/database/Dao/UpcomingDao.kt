package fariborz.com.database.Dao

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import fariborz.com.database.Entities.UpcomingEntry


/**
 * Created by Fariborz on 19/03/2020.
 */
@Dao
interface UpcomingDao {

    @Query("SELECT * FROM upcoming ORDER BY timeAdded ASC")
    fun loadAllUpcoming(): DataSource.Factory<Int, UpcomingEntry>

    @Query("SELECT * FROM upcoming WHERE movieId = :id ORDER BY timeAdded")
    fun checkIfUpcoming(id: Int):Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(upcoming: List<UpcomingEntry>)

    @Insert
    fun insertUpcoming(upcomingEntry: UpcomingEntry)

    @Delete
    fun deleteUpcoming(upcomingEntry: UpcomingEntry)

    @Query("DELETE FROM upcoming")
    fun deleteAll()

    @Query("SELECT COUNT(movieId) FROM upcoming")
    fun getNumberOfRows(): Int


}