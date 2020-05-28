package com.mvvm.kotlin.room.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "student", indices = {@Index(value = "email", unique = true)})
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int roll_no;
    private String name;
    private String email;
    @ColumnInfo(name = "phone_no")
    private String phone;
    @ColumnInfo(name = "thumbnail")
    private String profile_pic = "https://randomuser.me/api/portraits/thumb/women/68.jpg";


    public Student() {

    }

    public Student(int roll_no, String name, String email, String phone, String profile_pic) {
        this.roll_no = roll_no;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profile_pic = profile_pic;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }


    public boolean isValidName() {
        if (this.name != null && this.name.length() > 3) {
            return true;
        }

        return false;
    }

    public boolean isValidEmail() {
        if (this.email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }

        return false;
    }

    public boolean isValidPhoneNo() {
        if (this.phone != null && this.phone.length() == 10) {
            return true;
        }

        return false;
    }
}