package fariborz.com.requestmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fariborz.com.models.MovieReview

/**
 * Created by Fariborz on 19/03/2020.
 */
class MovieReviewsRequest {
    @SerializedName("results")
    @Expose
    var reviews: List<MovieReview>? = null
}