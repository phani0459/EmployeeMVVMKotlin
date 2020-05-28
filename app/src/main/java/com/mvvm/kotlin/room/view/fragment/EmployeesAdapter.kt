package com.mvvm.kotlin.room.view.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.kotlin.room.R
import com.mvvm.kotlin.room.databinding.ItemStudentBinding
import com.mvvm.kotlin.room.model.Employee

class EmployeesAdapter(val emps: List<Employee>, val context: Context) :
    RecyclerView.Adapter<EmployeesAdapter.EmpViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpViewHolder {
        val binding = DataBindingUtil.inflate<ItemStudentBinding>(
            LayoutInflater.from(context),
            R.layout.item_student,
            parent,
            false
        )
        return EmpViewHolder(binding)
    }

    override fun getItemCount() = emps.size

    override fun onBindViewHolder(holder: EmpViewHolder, position: Int) {
        holder.bind(emps[position])
    }

    inner class EmpViewHolder(val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(obj: Any) {
            binding.employee = obj as Employee
            binding.executePendingBindings()
        }
    }

}