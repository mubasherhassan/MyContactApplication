package com.example.zephyr.contact;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Zephyr on 3/21/2017.
 */

public class Person implements Serializable {
    private String name;
    private  String contactNo;

    Person(String name,String contactNo){
        this.name=name;
        this.contactNo=contactNo;


    }

    public String getContactNo() {
        return this.contactNo;
    }


    public String  getName(){
        return this.name;
    }
    public String toString(){
        return name;
    }



}




