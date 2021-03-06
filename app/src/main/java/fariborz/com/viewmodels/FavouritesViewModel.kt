package fariborz.com.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import fariborz.com.database.AppDatabase
import fariborz.com.database.Entities.FavouritesEntry

/**
 * Created by Fariborz on 19/03/2020.
 */
class FavouritesViewModel(application: Application) : AndroidViewModel(application) {

    private var movies: LiveData<MutableList<FavouritesEntry>>
    private val FavouritesViewModelTAG:String = "FavouritesViewModelTAG"

    init {
        val database: AppDatabase = AppDatabase.getInstance(this.getApplication())
        Log.d(FavouritesViewModelTAG,"Actively retrieving movies from database")
        movies = database.favouritesDao().loadAllFavourites()
    }

    fun getMovies(): LiveData<MutableList<FavouritesEntry>>{
        return movies
    }



}