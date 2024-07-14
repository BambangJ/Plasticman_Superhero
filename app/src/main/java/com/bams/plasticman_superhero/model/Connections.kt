package com.bams.plasticman_superhero.model

import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation")
    val groupaffiliation: String,

    val relatives: String
)
