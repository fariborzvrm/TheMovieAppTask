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
import fariborz.com.database.Entities.NowShowingEntry
import fariborz.com.interfaces.OnMovieClickListener
import fariborz.com.viewholders.NowShowingViewHolder

/**
 * Created by Fariborz on 19/03/2020.
 */
class NowShowingAdapter(private val listener: OnMovieClickListener,
                        private val mSharedPreferences: SharedPreferences) : PagedListAdapter<NowShowingEntry,
        RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.movie_single_item, parent, false)
                this.context = parent.context
                return NowShowingViewHolder(view,context,listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

                val movie: NowShowingEntry? = getItem(position)
                if (movie != null){
                    val movieViewHolder = holder as NowShowingViewHolder
                    movieViewHolder.bindNowShowingData(movie,mSharedPreferences)
                } else{
                    notifyItemRemoved(position)
                }
    }


    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<NowShowingEntry>() {
            override fun areItemsTheSame(oldItem: NowShowingEntry, newItem: NowShowingEntry): Boolean =
                    oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(oldItem: NowShowingEntry, newItem: NowShowingEntry): Boolean =
                    oldItem == newItem
        }
    }
}