package com.emrealtunbilek.youtubeplaylistlerim

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

/**
 * Created by Emre on 14.01.2018.
 */
class PlaylistAdapter(tumOynatmaListeleri:List<PlaylistData.Items>?) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    var oynatmaListeleri=tumOynatmaListeleri

    override fun getItemCount(): Int {

       return oynatmaListeleri!!.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlaylistViewHolder {

        var inflater=LayoutInflater.from(parent?.context)
        var tekSatirPlaylist=inflater.inflate(R.layout.tek_satir_playlist, parent, false)

        return PlaylistViewHolder(tekSatirPlaylist)

    }


    override fun onBindViewHolder(holder: PlaylistViewHolder?, position: Int) {

        var oanOlusturulanSatir=oynatmaListeleri?.get(position)
        holder?.setData(oanOlusturulanSatir,position)

    }



    inner class PlaylistViewHolder(itemView : View?) :RecyclerView.ViewHolder(itemView){

        var tekSatirPlaylist=itemView as CardView

        var playListTitle=tekSatirPlaylist.tvListeBaslik
        var playListImage = tekSatirPlaylist.imgListeResim



        fun setData(oanOlusturulanSatir: PlaylistData.Items?, pos:Int){

            playListTitle.text=oanOlusturulanSatir?.snippet?.title


        }

    }


}