package com.example.convidados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.repository.GuestDAO

//class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null,VERSION) {

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase() : RoomDatabase(){


    abstract fun guestDAO(): GuestDAO

    companion object {

        private lateinit var INSTANCE: GuestDataBase

        fun getDataBase(context:Context): GuestDataBase{
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(GuestDataBase::class){
                INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestbd")
                    .allowMainThreadQueries()
                    .addMigrations()
                    .build()
            } }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }

    }

}