package com.dimasdwipriyono_19102187.mainactivity.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class SettingModel (
        var name: String? = null,
        var email: String? = null,
        var age: Int = 0,
        var hobi: String? = null,
        var alamat: String? = null,
        var phoneNumber: String? = null,
        var isDarkTheme: Boolean = false
    ): Parcelable