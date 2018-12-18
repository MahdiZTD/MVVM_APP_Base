package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Venue {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("contact")
    var contact: Contact? = null
    @SerializedName("location")
    var location: Location? = null
    @SerializedName("canonicalUrl")
    var canonicalUrl: String? = null
    @SerializedName("categories")
    var categories: List<Category>? = null
    @SerializedName("verified")
    var verified: Boolean? = null
    @SerializedName("stats")
    var stats: Stats? = null
    @SerializedName("likes")
    var likes: Likes? = null
    @SerializedName("dislike")
    var dislike: Boolean? = null
    @SerializedName("ok")
    var ok: Boolean? = null
    @SerializedName("rating")
    var rating: Double? = null
    @SerializedName("ratingColor")
    var ratingColor: String? = null
    @SerializedName("ratingSignals")
    var ratingSignals: Int? = null
    @SerializedName("allowMenuUrlEdit")
    var allowMenuUrlEdit: Boolean? = null
    @SerializedName("beenHere")
    var beenHere: BeenHere? = null
    @SerializedName("specials")
    var specials: Specials? = null
    @SerializedName("photos")
    var photos: Photos? = null
    @SerializedName("reasons")
    var reasons: Reasons? = null
    @SerializedName("hereNow")
    var hereNow: HereNow? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("tips")
    var tips: Tips? = null
    @SerializedName("shortUrl")
    var shortUrl: String? = null
    @SerializedName("timeZone")
    var timeZone: String? = null
    @SerializedName("listed")
    var listed: Listed? = null
    @SerializedName("popular")
    var popular: Popular? = null
    @SerializedName("pageUpdates")
    var pageUpdates: PageUpdates? = null
    @SerializedName("inbox")
    var inbox: Inbox? = null
    @SerializedName("attributes")
    var attributes: Attributes? = null
    @SerializedName("bestPhoto")
    var bestPhoto: BestPhoto? = null
    @SerializedName("colors")
    var colors: Colors? = null

}
