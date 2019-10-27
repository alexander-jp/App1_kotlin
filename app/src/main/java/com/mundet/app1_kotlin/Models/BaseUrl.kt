package com.mundet.app1_kotlin.Models

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseUrl {
    fun getBaseUrl(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
/*        gson.registerTypeAdapter(Lugares::class.java, MyDeserialize::class.java)*/
        return Retrofit.Builder()
            .baseUrl("https://apidriver.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
