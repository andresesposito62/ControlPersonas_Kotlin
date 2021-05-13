package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonRoomDao {
    @Query("SELECT * FROM personsTable")
    fun getAll(): List<PersonRoom>

    @Query("SELECT * FROM personsTable WHERE personRoomId IN (:personRoomIds)")
    fun loadAllByIds(personRoomIds: IntArray): List<PersonRoom>

    @Query("SELECT * FROM personsTable WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): PersonRoom

    @Insert
    fun insertAll(vararg users: PersonRoom)

    @Delete
    fun delete(user: PersonRoom)
}