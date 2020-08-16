package com.androidexamples.examples.pixabayapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.androidexamples.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.pixabay_activity.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PixabayActivity : AppCompatActivity() {


    lateinit var adapter: PixabayImagesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pixabay_activity)

        supportActionBar?.hide()

        initRecyclerView()

        val baseUrl="https://pixabay.com/"
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api=retrofitBuilder.create(PixabayImagesApi::class.java)


        get_images_btn.setOnClickListener {
            val query = queryEditText.text.toString()
            if (query.isNotBlank()) {
                pixabayImageQuery(api,query)
            }
        }
    }

    private fun initRecyclerView() {
        adapter=
            PixabayImagesRecyclerViewAdapter()
        val layoutManager=GridLayoutManager(this,3)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
        recyclerView.setHasFixedSize(true)
    }

    private fun pixabayImageQuery(api: PixabayImagesApi, query:String) {

        api.getWebFormatImages(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleData){Log.e("PixabayActivity",it.message)}
    }

    private fun handleData(response:Response<PixabayImages>){
        if (response.isSuccessful){
            val body=response.body()
            body?.hits?.let {webFormatImages->
                adapter.addItems(webFormatImages)
            }
        }
    }

}