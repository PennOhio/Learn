package com.brian.remvp3.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PropertyDao {

    @Query("SELECT * FROM property")
    fun getAll(): List<Property>

    @Insert
    fun insert(property: Property)

    @Delete
    fun delete(property: Property)
}