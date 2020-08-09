package com.androidexamples.retrofit


import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface GetAlbums {

    @GET("photos")
    fun getAlbumList(): Single<Response<ArrayList<AlbumData>>>
}