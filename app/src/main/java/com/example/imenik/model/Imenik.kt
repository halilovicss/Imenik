package com.example.imenik.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "kontakti")
data class Imenik(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int =0,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name="phone")
    var phone: String?)
