package com.mvvm.kotlin.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var roll_no: Int = 0,
    var name: String? = null,
    var email: String? = null,
    @ColumnInfo(name = "phone_no")
    var phone: String? = null
)