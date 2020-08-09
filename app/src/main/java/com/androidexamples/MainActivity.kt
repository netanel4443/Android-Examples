package com.androidexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidexamples.genericrecyclerview.CommonType
import com.androidexamples.recyclerviews.SomeRecyclerViewAdapter
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val baseUrl="https://jsonplaceholder.typicode.com/"
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

         val data=retrofitBuilder.create(GetAlbums::class.java)

        data.getListOfAlbums().enqueue(object :Callback<ArrayList<AlbumData>>{
            override fun onFailure(call: Call<ArrayList<AlbumData>>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(
                call: Call<ArrayList<AlbumData>>,
                response: Response<ArrayList<AlbumData>>) {

                if (response.isSuccessful){
                    println("here")
                    val body=response.body()
                    body?.forEach {album->
                        println(album.albumId)
                        println(album.id)
                        println(album.title)
                        println(album.url)
                    }
                }

            }
        })


    }





}