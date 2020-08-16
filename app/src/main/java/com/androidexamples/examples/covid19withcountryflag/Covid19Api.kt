package com.androidexamples.examples.covid19withcountryflag

import com.androidexamples.examples.covid19withcountryflag.CountryDetails
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface Covid19Api {

    @GET("v3/covid-19/countries?yesterday=false&sort=cases")
    fun getDetailsSummary(): Single<Response<ArrayList<CountryDetails>>>
}