package com.mvvm.kotlin.room.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.kotlin.room.R
import com.mvvm.kotlin.room.view.fragment.AddEmployeeFragment
import com.mvvm.kotlin.room.view.fragment.EmployeeListFragment

class HomeActivity : AppCompatActivity(), EmployeeListFragment.NavigateToAddEmployee,
    AddEmployeeFragment.NavigateToEmployeeList {

    override fun loadEmployeeList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, EmployeeListFragment.newInstance())
            .commitNow()
    }

    override fun loadEmployee() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AddEmployeeFragment.newInstance())
            .commitNow()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EmployeeListFragment.newInstance())
                .commitNow()
        }
    }


}
