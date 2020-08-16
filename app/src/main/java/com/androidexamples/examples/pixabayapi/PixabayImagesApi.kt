package com.androidexamples.examples.pixabayapi

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayImagesApi {
     //key= Your Api Key after registering

    @GET("api/?key=API_KEY&per_page=200&image_type=photo")
    fun getWebFormatImages(@Query("q")query: String): Single<Response<PixabayImages>>
}