package fariborz.com.requestmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fariborz.com.models.Cast
import fariborz.com.models.Crew

/**
 * Created by Fariborz on 19/03/2020.
 */
class MovieCreditRequest {
    @SerializedName("cast")
    @Expose()
    var castResult: List<Cast>? = null

    @SerializedName("crew")
    @Expose()
    var crewResult: List<Crew>? = null
}