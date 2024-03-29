package com.example.convidados.repository

import android.app.Application
import android.content.ContentValues
import android.content.Context
import com.example.convidados.GuestDataBase
import com.example.convidados.GuestModel
import com.example.convidados.constants.DataBaseConstants

class GuestRepository (context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()


    fun insert(guest:GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0

    }

    fun delete (id:Int){
        val guest = get(id)
        return guestDataBase.delete(guest)

    }

    fun get(id:Int): GuestModel {
        return guestDataBase.get(id)

    }

    fun getAll(): List<GuestModel> {

        return guestDataBase.getAll()

    }

    fun getPresent(): List<GuestModel> {

        return guestDataBase.getPresent()

    }

    fun getAbsent(): List<GuestModel> {

        return guestDataBase.getAbsent()

    }





}

