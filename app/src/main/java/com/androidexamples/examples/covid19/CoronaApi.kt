package com.androidexamples.examples.covid19

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface CoronaApi {

    @GET("summary")
    fun getCoronaSummary(): Single<Response<Countries>>
}