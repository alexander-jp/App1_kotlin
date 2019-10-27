package com.mundet.app1_kotlin.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

class LugaresModel {
    @SerializedName("lugarId")
    var lugarId: Int? = null;
    @SerializedName("lugarNombre")
    var lugarNombre: String? = null;
    @SerializedName("lugarDescripcion")
    var lugarDescripcion: String? = null
    @SerializedName("lugarUbicacion")
    var lugarUbicacion: String? = null
    @SerializedName("lugarLatitud")
    var lugarLatitud: String? = null
    @SerializedName("lugarLongitud")
    var lugarLongitud: Int? = null
    @SerializedName("lugarCiudad")
    var lugarCiudad: String? = null
    @SerializedName("lugarPais")
    var lugarPais: String? = null
    @SerializedName("lugarCernano")
    var lugarCernano: String? = null
    @SerializedName("lugarImg")
    var lugarImg: String? = null

    constructor()

    constructor(
        lugarId: Int?,
        lugarNombre: String?,
        lugarDescripcion: String?,
        lugarUbicacion: String?,
        lugarLatitud: String?,
        lugarLongitud: Int?,
        lugarCiudad: String?,
        lugarPais: String?,
        lugarCernano: String?,
        lugarImg: String?
    ) {
        this.lugarId = lugarId
        this.lugarNombre = lugarNombre
        this.lugarDescripcion = lugarDescripcion
        this.lugarUbicacion = lugarUbicacion
        this.lugarLatitud = lugarLatitud
        this.lugarLongitud = lugarLongitud
        this.lugarCiudad = lugarCiudad
        this.lugarPais = lugarPais
        this.lugarCernano = lugarCernano
        this.lugarImg = lugarImg
    }


    override fun toString(): String {
        return "LugaresModel(lugarId=$lugarId, lugarNombre=$lugarNombre, lugarDescripcion=$lugarDescripcion, lugarUbicacion=$lugarUbicacion, lugarLatitud=$lugarLatitud, lugarLongitud=$lugarLongitud, lugarCiudad=$lugarCiudad, lugarPais=$lugarPais, lugarCernano=$lugarCernano, lugarImg=$lugarImg)"
    }


}


