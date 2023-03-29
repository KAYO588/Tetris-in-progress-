package com.example.tetrisgod.Storage

import android.content.Context
import android.content.SharedPreferences


private const val NAME_SHARED = "APP_PREF"
private const val HIGH_SCORE = "HIGH_SCORE"
class AppPreferences(context: Context) {

    val data: SharedPreferences = context.getSharedPreferences(NAME_SHARED, Context.MODE_PRIVATE)


    fun saveHighScore(highScore: Int){
        data.edit().putInt(HIGH_SCORE,highScore).apply()
    }


    fun getHighScore():Int{
        return data.getInt(HIGH_SCORE,0)
    }

    fun clearHighScore(){
        data.edit().putInt(HIGH_SCORE,0).apply()
    }







}