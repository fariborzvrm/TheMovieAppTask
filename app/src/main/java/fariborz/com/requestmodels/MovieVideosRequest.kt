package fariborz.com.requestmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fariborz.com.models.MovieVideo

/**
 * Created by Fariborz on 19/03/2020.
 */
class MovieVideosRequest {
    @SerializedName("results")
    @Expose
    var videos: List<MovieVideo>? = null
}