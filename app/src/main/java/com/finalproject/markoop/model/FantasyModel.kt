package com.finalproject.markoop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FantasyModel (
    var fantasyCover : Int,
    var fantasyTitle : String,
    var fantasyGenre : String,
    var fantasySynopsis : String,
    var fantasyAuthor : String,
    var fantasyEpisodeTitle : String,
    var fantasyReleaseDate : String,
    var fantasyHeadline : String,
    var fantasyContent : String,
) : Parcelable