package com.androidexamples.examples.covid19withcountryflag

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Covid19DetailsWithFlags {

    private fun getCovid19DetailsPerCountry() {
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://disease.sh/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        val api=retrofitBuilder.create(Covid19Api::class.java)

        api.getDetailsSummary().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleData){Log.e("PixabayActivity",it.message)}
    }

    private fun handleData(response:Response<ArrayList<CountryDetails>>){
        if (response.isSuccessful){
            val body=response.body()

            body?.let {
               /// adapter.addItems(it) //recyclerview adapter
            }
        }
    }
}