package fariborz.com.viewholders

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import fariborz.com.R
import fariborz.com.database.Entities.PopularEntry
import fariborz.com.interfaces.OnMovieClickListener
import fariborz.com.models.Movie
import fariborz.com.utils.Constants
import fariborz.com.utils.DateUtils
import fariborz.com.utils.Helpers
import kotlinx.android.synthetic.main.movie_single_item.view.*

/**
 * Created by Fariborz on 19/03/2020.
 */
class PopularViewHolder(itemView: View?,
                           val context: Context,
                           val listener: OnMovieClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var movieTitle: TextView
    var movieRating: RatingBar
    var movieType: TextView
    var movieReleaseDate: TextView
    var moviePoster: ImageView
    var movieDetails: LinearLayout
    var movieOverView: TextView
    private var movie: PopularEntry? = null

    init{
        movieTitle = itemView!!.findViewById(R.id.single_item_movie_title)
        movieRating = itemView.findViewById(R.id.single_item_movie_rating)
        movieType = itemView.findViewById(R.id.single_item_movie_type)
        movieReleaseDate = itemView.findViewById(R.id.single_item_movie_release_date)
        moviePoster = itemView.findViewById(R.id.single_item_movie_image)
        movieDetails = itemView.findViewById(R.id.single_item_movie_details)
        movieOverView = itemView.findViewById(R.id.single_item_movie_overview)

        itemView.setOnClickListener(this)

    }

    fun bindPopularData(movie: PopularEntry?, mSharedPreferences: SharedPreferences) {
        if (movie == null) {
            return
        } else {

            this.movie = movie

            movieTitle.setText(movie.title)
            movieRating.rating = movie.voteAverage!!.div(2)
            movieReleaseDate.setText("Release date: ".plus(DateUtils.getStringDate(movie.releaseDate!!)))
            movieOverView.text = movie.overview

            itemView.single_item_movie_type.setText("Genre: "+movie.genreString)


            if (mSharedPreferences.getBoolean(context.getString(R.string.pref_cache_data_key),true)){
                Glide.with(context).load(Helpers.buildImageUrl(movie.posterPath!!)).thumbnail(0.05f)
                        .transition(DrawableTransitionOptions.withCrossFade()).into(moviePoster)
            } else{
                Glide.with(context).load(Helpers.buildImageUrl(movie.posterPath!!)).thumbnail(0.05f)
                        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true))
                        .transition(DrawableTransitionOptions.withCrossFade()).into(moviePoster)
            }
        }
    }

    private fun convertEntryToMovieList(movie: PopularEntry): Movie {
        val passMovie = Movie()
        passMovie.id = movie.movieId
        passMovie.voteCount = movie.voteCount
        passMovie.video = movie.video
        passMovie.voteAverage = movie.voteAverage
        passMovie.title = movie.title
        passMovie.popularity = movie.popularity
        passMovie.posterPath = movie.posterPath!!
        passMovie.originalLanguage = movie.originalLanguage
        passMovie.originalTitle = movie.originalTitle
        passMovie.backdropPath = movie.backdropPath!!
        passMovie.adult = movie.adult
        passMovie.overview = movie.overview
        passMovie.releaseDate = movie.releaseDate
        passMovie.genreString = movie.genreString!!
        passMovie.contentType = Constants.CONTENT_MOVIE
        passMovie.tableName = Constants.SEARCHES
        return passMovie
    }


    override fun onClick(p0: View?) {
        val position:Int = adapterPosition
        if (position!= RecyclerView.NO_POSITION){
            listener.onMovieClickListener(convertEntryToMovieList(movie!!))
        }
    }

}