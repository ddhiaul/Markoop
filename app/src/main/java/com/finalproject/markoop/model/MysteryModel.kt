package com.finalproject.markoop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MysteryModel (
    var mysteryCover : Int,
    var mysteryTitle : String,
    var mysteryGenre : String,
    var mysterySynopsis : String,
    var mysteryAuthor : String,
    var mysteryEpisodeTitle : String,
    var mysteryReleaseDate : String,
    var mysteryHeadline : String,
    var mysteryContent : String,
) : Parcelable