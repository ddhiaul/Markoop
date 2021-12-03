package com.finalproject.markoop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RomanceModel (
    var romanceCover : Int,
    var romanceTitle : String,
    var romanceGenre : String,
    var romanceSynopsis : String,
    var romanceAuthor : String,
    var romanceEpisodeTitle : String,
    var romanceReleaseDate : String,
    var romanceHeadline : String,
    var romanceContent : String,
) : Parcelable