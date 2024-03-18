package com.example.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.GuestModel
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.view.listener.OnGuestListener
import com.example.convidados.view.viewholder.GuestsViewHolder

class GuestsAdapter: RecyclerView.Adapter<GuestsViewHolder> {


    private var guestlist: List<GuestModel> = listOf()
    private var listener: OnGuestListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestsViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestsViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestsViewHolder, position: Int) {
        holder.bind(guestlist[position])
    }

    override fun getItemCount(): Int {
        return guestlist.count()
    }

    fun updateGuests(list: List<GuestModel>) {
        guestlist = list
    }

    fun attachListener(guestlistener: OnGuestListener){
        listener = guestlistener

    }

}