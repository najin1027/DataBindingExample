package com.mvlist.databindingexample;

import android.view.View;
import android.widget.Toast;

public class User {

    private String name;
    private int age;

    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onClicker(View view){
        Toast.makeText(view.getContext() , "Test Toast", Toast.LENGTH_SHORT).show();
    }


    public void setAge(int age) {
        this.age = age;
    }
}
