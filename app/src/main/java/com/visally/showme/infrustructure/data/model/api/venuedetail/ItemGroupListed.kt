package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class ItemGroupListed {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("user")
    var user: UserItemGroupListed? = null
    @SerializedName("editable")
    var editable: Boolean? = null
    @SerializedName("public")
    var public: Boolean? = null
    @SerializedName("collaborative")
    var collaborative: Boolean? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("canonicalUrl")
    var canonicalUrl: String? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("updatedAt")
    var updatedAt: Int? = null
    @SerializedName("followers")
    var followers: Followers? = null
    @SerializedName("listItems")
    var listItems: ListItems? = null
    @SerializedName("photo")
    var photo: PhotoItemGroupListed? = null

}
