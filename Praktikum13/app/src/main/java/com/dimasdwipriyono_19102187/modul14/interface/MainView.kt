package com.dimasdwipriyono_19102187.modul14.`interface`

import com.dimasdwipriyono_19102187.modul14.model.Login
import com.dimasdwipriyono_19102187.modul14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}