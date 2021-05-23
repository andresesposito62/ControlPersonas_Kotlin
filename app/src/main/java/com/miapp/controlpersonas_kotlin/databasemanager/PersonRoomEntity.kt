package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonRoomEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var indentification: String,
    var names: String,
    var surnames: String,
    var phone: String,
    var temperature: String,
    var rol : String
)
