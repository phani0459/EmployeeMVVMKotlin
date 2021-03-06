package com.mvvm.kotlin.room.view.fragment

import android.app.Application
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.mvvm.kotlin.room.data.DatabaseInitializer
import com.mvvm.kotlin.room.data.db.AppDataBase
import com.mvvm.kotlin.room.model.Employee
import com.mvvm.kotlin.room.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmployeeViewModel(application: Application) : BaseViewModel(application) {
    val context = application.applicationContext
    var employees = MutableLiveData<List<Employee>>()
    var employeeSaveResult = MutableLiveData<Long>()

    fun getEmployees() {
        getCompositeDisposable().add(
            DatabaseInitializer.getAllStudent(AppDataBase.getDatabase(context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    this::handleResponse,
                    this::handleError
                )
        )
    }

    fun addEmployee(emp: Employee) {
        getCompositeDisposable().add(
            DatabaseInitializer.insertStudent(AppDataBase.getDatabase(context), emp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    this::handleInsertResponse,
                    this::handleError
                )
        )
    }

    fun isValidName(name: String?): Boolean {
        return name != null && name.length > 3
    }

    fun isValidEmail(email: String?): Boolean {
        return email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(
            email
        ).matches()
    }

    fun isValidPhoneNo(phone: String?): Boolean {
        return phone != null && phone.length == 10
    }

    private fun handleResponse(employeesResponse: List<Employee>) {
        Log.e("asfsaf", "phain::::" + employeesResponse)
        employees.value = employeesResponse
    }

    private fun handleInsertResponse(insertResponse: Long) {
        employeeSaveResult.value = insertResponse
    }

    private fun handleError(error: Throwable) {
        employees.value = emptyList()
    }

}
