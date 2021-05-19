package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonRoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val indentification: String,
    val names: String,
    val surnames: String,
    val phone: String,
    val temperature: String,
    val rol : String
)
