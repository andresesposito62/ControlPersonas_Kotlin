package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.*

@Dao
interface PersonDao {

    //function suspend for use of corroutines
    @Query("SELECT * FROM PersonRoomEntity")
    suspend fun getAll(): List<PersonRoomEntity>

    @Query("SELECT * FROM PersonRoomEntity WHERE indentification = :identification")
    suspend fun getById(identification: String): PersonRoomEntity

    @Update
    suspend fun update(person: PersonRoomEntity)

    @Insert
    suspend fun insert(persons: List<PersonRoomEntity>)

    @Delete
    suspend fun delete(person: PersonRoomEntity)
}