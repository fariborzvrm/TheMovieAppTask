package fariborz.com.database.Dao

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import fariborz.com.database.Entities.NowShowingEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
@Dao
 interface NowShowingDao {

    @Query("SELECT * FROM nowshowing ORDER BY timeAdded ASC")
    fun loadAllNowShowing(): DataSource.Factory<Int, NowShowingEntry>

    @Query("SELECT * FROM nowshowing WHERE movieId = :id ORDER BY timeAdded")
    fun checkIfNowShowing(id: Int):Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowShowing(nowShowingEntry: NowShowingEntry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(searches: List<NowShowingEntry>)

    @Delete
    fun deleteNowShowing(nowShowingEntry: NowShowingEntry)

    @Query("DELETE FROM nowshowing")
    fun deleteAll()

    @Query("SELECT COUNT(movieId) FROM nowshowing")
    fun getNumberOfRows(): Int

}