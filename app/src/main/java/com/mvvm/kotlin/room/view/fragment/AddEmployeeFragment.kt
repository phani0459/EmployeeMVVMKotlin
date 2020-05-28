package com.mvvm.kotlin.room.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mvvm.kotlin.room.R
import com.mvvm.kotlin.room.databinding.ActivityStudentBinding
import com.mvvm.kotlin.room.model.Employee
import com.mvvm.kotlin.room.view.HomeActivity
import kotlinx.android.synthetic.main.activity_student.view.*

class AddEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() = AddEmployeeFragment()
    }

    private lateinit var binding: ActivityStudentBinding
    private lateinit var viewModel: EmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.activity_student, container, false)
        return binding.root
    }

    fun showToast(msg: String) {
        Toast.makeText(context!!, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)

        viewModel.employeeSaveResult
            .observe(this, Observer<Long> {
                if (!it.equals(-1)) {
                    showToast("Employee Added Successfully")
                    (activity as HomeActivity).loadEmployeeList()
                }
            })

        binding.saveEmployeeClick = View.OnClickListener {
            val name = binding.editName.text.toString()

            if (!viewModel.isValidName(name)) {
                showToast("Enter Valid Name")
                return@OnClickListener
            }

            val email = binding.editEmail.text.toString()

            if (!viewModel.isValidEmail(email)) {
                showToast("Enter Valid Email")
                return@OnClickListener
            }

            val mobile = binding.editMobileNo.text.toString()

            if (!viewModel.isValidPhoneNo(mobile)) {
                showToast("Enter Valid Mobile")
                return@OnClickListener
            }

            viewModel.addEmployee(Employee(name = name, email = email, phone = mobile))
        }


    }

    interface NavigateToEmployeeList {
        fun loadEmployeeList()
    }

}
