package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PersonRoom::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun personRoomDao(): PersonRoomDao
}