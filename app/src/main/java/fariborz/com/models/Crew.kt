package fariborz.com.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Fariborz on 19/03/2020.
 */
class Crew {

    @SerializedName("department")
    @Expose
    var department: String? = null
    @SerializedName("credit_id")
    @Expose
    var creditId: String? = null
    @SerializedName("id")
    @Expose
    var id: Int = -1
    var contentType: Int = 0
    @SerializedName("name")
    @Expose
    var name:String? = null
    @SerializedName("profile_path")
    @Expose
    var profilePath: String? = null
}