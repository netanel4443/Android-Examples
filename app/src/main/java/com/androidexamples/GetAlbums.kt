package com.androidexamples

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GetAlbums {

    @GET("photos")
    fun getListOfAlbums(): Call<ArrayList<AlbumData>>
}