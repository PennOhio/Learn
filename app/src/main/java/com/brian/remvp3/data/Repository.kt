package com.brian.remvp3.data

import com.brian.remvp3.data.local.Property
import com.brian.remvp3.data.local.PropertyDatabase
import javax.inject.Inject

class Repository @Inject constructor(private val propertyDatabase: PropertyDatabase) {

    fun getAll(): List<Property> {
        return propertyDatabase.propertyDao().getAll()
    }

    fun insert(property: Property) {
        return propertyDatabase.propertyDao().insert(property)
    }

    fun delete(property: Property) {
        return propertyDatabase.propertyDao().delete(property)
    }
}
