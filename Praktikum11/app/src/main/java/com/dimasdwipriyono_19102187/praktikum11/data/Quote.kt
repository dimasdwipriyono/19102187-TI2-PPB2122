package com.dimasdwipriyono_19102187.praktikum11.data

import android.os.Parcelable
import com.google.firebase.Timestamp
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quote(
    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    var category: String? = null,
    var date: Timestamp? = null
) : Parcelable