package net.falhosh.kotlinbitvoodoo.model

import com.google.gson.annotations.SerializedName


data class JiraPayload (

    @SerializedName("fields")
    var fields: Fields

)