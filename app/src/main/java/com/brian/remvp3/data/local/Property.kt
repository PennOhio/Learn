package com.brian.remvp3.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property")
data class Property(
        @PrimaryKey(autoGenerate = true) val uid: Int = 0,
        @ColumnInfo(name = "address") val address: String,
        @ColumnInfo(name = "numberOne") val numberOne: Int,
        @ColumnInfo(name = "numberTwo") val numberTwo: Int

)
