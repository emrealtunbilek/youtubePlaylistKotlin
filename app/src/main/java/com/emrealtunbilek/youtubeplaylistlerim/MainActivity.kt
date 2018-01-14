package com.emrealtunbilek.youtubeplaylistlerim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyA0v9F6KnUTL9ZM_bXYEOfNVyh6ZImgr3E"
    val CHANNEL_ID="UClpEUtFu_dXbrUJ6kc3QtlA"
    var gelenVeri:PlaylistData? = null
    var oynatmaListeleri:List<PlaylistData.Items> ?= null

    var myAdapter:PlaylistAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface=ApiClient.client?.create(ApiInterface::class.java)
        var apiCall=apiInterface?.tumListeleriGetir(CHANNEL_ID,API_KEY,25)

        apiCall?.enqueue(object : Callback<PlaylistData>{

            override fun onResponse(call: Call<PlaylistData>?, response: Response<PlaylistData>?) {
                Log.e("BASARILI", ""+call?.request()?.url()?.toString())

                gelenVeri=response?.body()
                oynatmaListeleri=gelenVeri?.items

                myAdapter= PlaylistAdapter(oynatmaListeleri)

                supportActionBar?.setSubtitle("Toplam Liste :"+oynatmaListeleri?.size)

                Log.e("BASARILI","TOPLAM LİSTE SAYISI"+gelenVeri?.pageInfo?.totalResults)


            }

            override fun onFailure(call: Call<PlaylistData>?, t: Throwable?) {
                Log.e("HATA", ""+t?.printStackTrace())
            }


        })








    }

}
