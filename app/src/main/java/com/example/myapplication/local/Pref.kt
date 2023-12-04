package com.example.myapplication.local

import android.content.Context

class Pref(private val context: Context) {
    val sharedPreferences = context.getSharedPreferences(PREF_NAE, Context.MODE_PRIVATE)

    fun saveData(loadDataName: String) {
        sharedPreferences.edit().putString(TEXT_PREF_KEY, loadDataName).apply()
    }

    fun getName(): String {
        val tvGetData = sharedPreferences.getString(TEXT_PREF_KEY, "")
        return tvGetData.toString()
    }


    companion object {
        //Pref Key
        const val PREF_NAE = "pref.naem"

        //String Data Key
        const val TEXT_PREF_KEY = "text.pref.key"

    }
}