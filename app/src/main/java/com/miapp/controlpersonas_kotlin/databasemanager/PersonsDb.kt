package com.miapp.controlpersonas_kotlin.databasemanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PersonRoomEntity::class],
    version = 2
)
abstract class PersonsDb:RoomDatabase() {

    abstract fun  personDao(): PersonDao

    companion object {

        private const val DATABASE_NAME = "person"

        fun getDatabase(context: Context): PersonsDb = Room.databaseBuilder(
            context.applicationContext,
            PersonsDb::class.java,
            DATABASE_NAME
        ).enableMultiInstanceInvalidation().build()

    }
}