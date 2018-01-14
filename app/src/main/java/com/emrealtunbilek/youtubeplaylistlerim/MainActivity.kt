package com.emrealtunbilek.youtubeplaylistlerim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyDiVMt7qbRTgQDQdcblvwDCNt7xJJTiwlU"
    val CHANNEL_ID="UClpEUtFu_dXbrUJ6kc3QtlA"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface=ApiClient.client?.create(ApiInterface::class.java)
        var apiCall=apiInterface?.tumListeleriGetir(CHANNEL_ID,API_KEY,25)

        apiCall?.enqueue(object : Callback<PlaylistData>{

            override fun onResponse(call: Call<PlaylistData>?, response: Response<PlaylistData>?) {
                Log.e("BASARILI", ""+call?.request()?.url()?.toString())
                var gelenData=response?.body()

                for(i in 0..response?.body()?.items?.size!!-1)
                Log.e("BASARILI", ""+response?.body()?.items?.get(i)?.snippet?.title?.toString())
            }

            override fun onFailure(call: Call<PlaylistData>?, t: Throwable?) {
                Log.e("HATA", ""+t?.printStackTrace())
            }


        })




    }
}
