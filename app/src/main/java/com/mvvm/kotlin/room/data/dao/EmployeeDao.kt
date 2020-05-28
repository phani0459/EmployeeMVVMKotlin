package com.mvvm.kotlin.room.data.dao

import androidx.room.*
import com.mvvm.kotlin.room.model.Employee
import io.reactivex.Single

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM STUDENT")
    fun getAll(): Single<List<Employee>>

    @Query("SELECT COUNT(*) FROM STUDENT")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Employee): Single<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(students: List<Employee>): LongArray

    @Delete
    fun delete(student: Employee)

}