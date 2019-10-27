package com.mundet.app1_kotlin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.mundet.app1_kotlin.Controllers.Adapters.RecyclerAdapter
import com.mundet.app1_kotlin.Models.BaseUrl
import com.mundet.app1_kotlin.Models.JsonData
import com.mundet.app1_kotlin.Models.Lugares
import com.mundet.app1_kotlin.Models.LugaresModel
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList
import retrofit2.Call
import java.util.*
import java.util.Arrays.asList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.mundet.app1_kotlin.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    //var btnClick: Button? = null
    var arrayList: ArrayList<LugaresModel> = ArrayList()
    var adapter: RecyclerAdapter = RecyclerAdapter()
    var arrayData: LugaresModel = LugaresModel()
    var recyclerView: RecyclerView? = null;
    var composite: CompositeDisposable = CompositeDisposable()
    var BASE_URL: String? = "https://apidriver.herokuapp.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        composite = CompositeDisposable();
        recyclerView = findViewById(R.id.listaPrincipal) as RecyclerView;
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        val service = BaseUrl().getBaseUrl().create(JsonData::class.java)

        composite.add(
            service.listLugares().observeOn(AndroidSchedulers.mainThread()).subscribeOn(
                Schedulers.io()
            ).subscribe(this::handleResponse)
        )


        /* Thread(Runnable {
             val call = BaseUrl().getBaseUrl().create(JsonData::class.java).listLugares()
             call.enqueue(object : Callback<List<LugaresModel>> {
                 override fun onResponse(
                     call: Call<List<LugaresModel>>,
                     response: Response<List<LugaresModel>>
                 ) {
                     val lug: List<LugaresModel> = response.body()!!
                     adapter.RecyclerAdapter(response.body()!!, applicationContext)
                     recyclerView?.adapter = adapter
                 }

                 override fun onFailure(call: Call<List<LugaresModel>>, t: Throwable) {
                     Log.i("TAG", t.message)
                 }

             })
         }).start()*/

//        composite?.add(
//            requestInterface.listLugares().observeOn(AndroidSchedulers.mainThread()).subscribeOn(
//                Schedulers.io()
//            ).subscribe(this::handleReponse)
//        )

        /* myAlexander.setOnClickListener {
             Toast.makeText(
                 applicationContext,
                 "hola a todos",
                 Toast.LENGTH_LONG
             ).show()
         }*/
        //btnClick = findViewById(R.id.btnClick) as Button
        //btnClick?.setOnClickListener {
        // Toast.makeText(applicationContext, "hola a todos", Toast.LENGTH_LONG).show()
        //}
    }


    fun handleResponse(lista: List<LugaresModel>) {
        adapter.RecyclerAdapter(lista, applicationContext)
        recyclerView?.adapter = adapter
    }


}
