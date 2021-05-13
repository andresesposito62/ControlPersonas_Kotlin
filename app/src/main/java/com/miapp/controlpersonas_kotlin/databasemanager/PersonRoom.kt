package com.miapp.controlpersonas_kotlin.databasemanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personsTable")
data class PersonRoom(
    @PrimaryKey val personRoomId: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
