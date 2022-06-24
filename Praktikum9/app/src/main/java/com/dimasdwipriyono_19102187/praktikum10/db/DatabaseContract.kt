package com.dimasdwipriyono_19102187.praktikum10.db

import android.provider.BaseColumns

class DatabaseContract {
    internal class QuoteColumns : BaseColumns {
        companion object {
            const val TABLE_QUOTE = "quote"
            const val _ID = "_id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val CATEGORY = "category"
            const val DATE = "date"
        }
    }
}