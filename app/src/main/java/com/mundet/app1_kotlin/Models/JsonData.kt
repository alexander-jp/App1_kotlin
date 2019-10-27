package com.mundet.app1_kotlin.Models

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface JsonData {

    @GET("/getLugares")
    fun listLugares(): Observable<List<LugaresModel>>
}
