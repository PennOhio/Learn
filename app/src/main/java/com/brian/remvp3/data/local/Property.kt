package com.brian.remvp3.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property")
data class Property(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "address") val address: String
)
