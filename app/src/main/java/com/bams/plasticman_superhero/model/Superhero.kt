package com.bams.plasticman_superhero.model

import android.net.Uri
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class Superhero(
    val id: String,
    val name: String,
    val powerstats: PowerStats,
    val biography: Biography,
    val connections: Connections,
    @SerializedName("image")
    val image: Image
)

data class PowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)


data class Image(
    @SerializedName("url")
    val url: String
)