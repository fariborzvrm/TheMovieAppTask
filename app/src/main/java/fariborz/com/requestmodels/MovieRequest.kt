package fariborz.com.requestmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fariborz.com.models.Movie

/**
 * Created by Fariborz on 19/03/2020.
 */
class MovieRequest {
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int = 0
    @SerializedName("page")
    @Expose
    var page: Int = 0
    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null
}