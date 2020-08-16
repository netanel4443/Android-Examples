package com.androidexamples.examples.covid19

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Covid19Details {

    private fun coronaDetails() {
        val baseUrl="https://api.covid19api.com/"

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val data=retrofitBuilder.create(CoronaApi::class.java)

        data.getCoronaSummary().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleData){ Log.e("PixabayActivity",it.message)}
    }

    private fun handleData(response: Response<Countries>){

        if (response.isSuccessful){
            val body=response.body()

            body?.countries?.let {
            //    adapter.addItems(it)//recyclerview adapter
            }

        }
    }
}