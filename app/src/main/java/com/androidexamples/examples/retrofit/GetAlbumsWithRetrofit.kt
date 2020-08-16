package com.androidexamples.examples.retrofit

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GetAlbumsWithRetrofit() {

    fun getAlbums(){
        val baseUrl="https://jsonplaceholder.typicode.com/"

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val data=retrofitBuilder.create(GetAlbums::class.java)

        data.getAlbumList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleData){ Log.e("PixabayActivity",it.message)}

}
private fun handleData(response: Response<ArrayList<AlbumData>>){
    if (response.isSuccessful){
        val data=response.body()

        data?.forEach {album->
            println(album.url)
        }
    }
}
}