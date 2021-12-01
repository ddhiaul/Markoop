package com.finalproject.markoop.genre

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreModel (
    var novelCover : Int,
    var novelTitle : String,
    var novelGenre : String,
    var novelSynopsis : String,
    var novelAuthor : String,
    var episodeTitle : String,
    var releaseDate : String,
    var headline : String,
    var content : String,
) : Parcelable