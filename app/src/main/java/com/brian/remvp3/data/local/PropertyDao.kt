package com.brian.remvp3.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PropertyDao {

    @Query("SELECT * FROM property")
    suspend fun getAll(): List<Property>

    @Insert
    suspend fun insert(property: Property)

    @Delete
    suspend fun delete(property: Property)
}