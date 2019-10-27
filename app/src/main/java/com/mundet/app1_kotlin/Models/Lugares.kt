package com.mundet.app1_kotlin.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Lugares {
    @SerializedName("Lugares")
    @Expose
    var array: ArrayList<LugaresModel> = ArrayList()

    override fun toString(): String {
        return "Lugares(array=$array)"
    }


}