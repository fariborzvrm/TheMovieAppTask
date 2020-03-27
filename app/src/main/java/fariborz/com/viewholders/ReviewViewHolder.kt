package fariborz.com.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import fariborz.com.R
import fariborz.com.interfaces.OnReviewReadMoreClickListener
import fariborz.com.models.MovieReview

/**
 * Created by Fariborz on 19/03/2020.
 */
class ReviewViewHolder(itemView: View?, context: Context,
                       val listener: OnReviewReadMoreClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var mReviewAuthor: TextView
    var mReviewContent: TextView
    var mReadMoreButton: TextView
    private var mReview: MovieReview? = null

    init{
        mReviewAuthor = itemView!!.findViewById(R.id.review_author_name)
        mReviewContent = itemView.findViewById(R.id.review_content)
        mReadMoreButton = itemView.findViewById(R.id.review_read_more)
        itemView.setOnClickListener(this)
    }

    fun bindReviewData(movie: MovieReview?) {
        if (movie == null) {
            return
        } else {
            this.mReview = movie
            mReviewAuthor.setText(mReview!!.author)
            mReviewContent.setText(mReview!!.content)

        }
    }

    override fun onClick(p0: View?) {
        val position: Int = adapterPosition
        if (position!=RecyclerView.NO_POSITION){
                listener.onReviewReadMoreClickListener(mReview!!)
            }
        }
}
