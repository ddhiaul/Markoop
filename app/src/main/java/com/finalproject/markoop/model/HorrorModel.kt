package com.finalproject.markoop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HorrorModel (
    var horrorCover : Int,
    var horrorTitle : String,
    var horrorGenre : String,
    var horrorSynopsis : String,
    var horrorAuthor : String,
    var horrorEpisodeTitle : String,
    var horrorReleaseDate : String,
    var horrorHeadline : String,
    var horrorContent : String,
) : Parcelable