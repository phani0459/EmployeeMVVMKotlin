package com.mvvm.kotlin.room.data

import com.mvvm.kotlin.room.data.db.AppDataBase
import com.mvvm.kotlin.room.model.Employee
import io.reactivex.Single

class DatabaseInitializer {
    companion object {
        val TAG = DatabaseInitializer::class.java.name

        fun insertStudent(db: AppDataBase, student: Employee): Single<Long> {
            return db.employeeDao().insert(student)
        }

        fun getAllStudent(db: AppDataBase): Single<List<Employee>> {
            return db.employeeDao().getAll()
        }

    }
}