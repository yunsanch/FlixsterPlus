package com.example.flixster

import com.google.gson.annotations.SerializedName
/**
 * The Model for storing a single book from the NY Times API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */

class Movies {

    @JvmField
    @SerializedName("title")
    var title: String? = null

//    @JvmField
//    @SerializedName("author")
//    var author: String? = null

    //TODO bookImageUrl
    @SerializedName("poster_path")
    var MoviePosterImageUrl: String? = null




    //TODO description
    @SerializedName("overview")
    var description: String? = null

    //TODO-STRETCH-GOALS amazonUrl
    @SerializedName("amazon_product_url")
    var amazonUrl: String? = null
}