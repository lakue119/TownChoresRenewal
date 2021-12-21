package com.lakue.townchoresrenewal.extention

import com.google.gson.Gson

val gson = Gson()

inline fun <reified T> String.fromJson() =
    gson.fromJson(this, T::class.java)

fun <T> T.toJson() =
    gson.toJson(this)
