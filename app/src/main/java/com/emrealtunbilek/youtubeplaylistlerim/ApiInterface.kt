package com.emrealtunbilek.youtubeplaylistlerim

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Emre on 14.01.2018.
 */
interface ApiInterface {
//https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UClpEUtFu_dXbrUJ6kc3QtlA&key={YOUR_API_KEY}
    @GET("playlists?part=snippet")
    fun  tumListeleriGetir(@Query("channelId") channelID:String, @Query("key") apiKey:String, @Query("maxResults") limit:Int):Call<PlaylistData>


}