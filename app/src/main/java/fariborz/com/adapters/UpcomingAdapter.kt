package fariborz.com.adapters

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fariborz.com.R
import fariborz.com.database.Entities.UpcomingEntry
import fariborz.com.interfaces.OnMovieClickListener
import fariborz.com.viewholders.UpcomingViewHolder

/**
 * Created by Fariborz on 19/03/2020.
 */
class UpcomingAdapter(private val listener: OnMovieClickListener,
                        private val mSharedPreferences: SharedPreferences) : PagedListAdapter<UpcomingEntry,
        RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_single_item, parent, false)
        this.context = parent.context
        return UpcomingViewHolder(view,context,listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val movie: UpcomingEntry? = getItem(position)

        if (movie != null){
            val movieViewHolder = holder as UpcomingViewHolder
            movieViewHolder.bindNowShowingData(movie,mSharedPreferences)
        } else{
            notifyItemRemoved(position)
        }

    }


    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<UpcomingEntry>() {
            override fun areItemsTheSame(oldItem: UpcomingEntry, newItem: UpcomingEntry): Boolean =
                    oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(oldItem: UpcomingEntry, newItem: UpcomingEntry): Boolean =
                    oldItem == newItem
        }
    }
}