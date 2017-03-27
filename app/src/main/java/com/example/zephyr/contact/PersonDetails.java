package com.example.zephyr.contact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Zephyr on 3/22/2017.
 */

public class PersonDetails extends Activity{
    GradientDrawable gradientObject;
    TextView nameView,phoneNumber,twoCharacter;
    Person student;
    String singleName,twoLetter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);
        getAllViews();



//        Bundle data = getIntent().getExtras();
//        student = (Person) data.getParcelable("contact");
        TextView listImage=(TextView) findViewById(R.id.resultImage);
        gradientObject = (GradientDrawable)listImage.getBackground();



        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        student= (Person)bundle.getSerializable("value");

        setAllViews();
        setColor();
    }
    private  String devideNameIntoTwoCharacter(){
        String[] words=student.getName().split(" ");//splits the string based on whitespace
        //using java foreach loop to print elements of string array
        String tempCharater="";
        for(String w:words){
            tempCharater+=w.charAt(0);
        }
        return tempCharater;
    }

    private  void getAllViews(){
        nameView=(TextView)findViewById(R.id.nameView) ;
        twoCharacter=(TextView) findViewById(R.id.twoCharacter);
        phoneNumber=(TextView)findViewById(R.id.mobileNumber);
    }


    private  void setAllViews(){
        nameView.setText(student.getName());

        twoLetter= devideNameIntoTwoCharacter();
        twoCharacter.setText(twoLetter);
        phoneNumber.setText(student.getContactNo());
    }
    private  void setColor(){
        if(twoLetter.charAt(0)>='A' && twoLetter.charAt(0)<='D') {
            gradientObject.setColor(Color.parseColor("#00FFFF"));

        }
        else if(twoLetter.charAt(0)>='E' && twoLetter.charAt(0)<='H') {
            gradientObject.setColor(Color.parseColor("#8A2BE2"));

        }else if(twoLetter.charAt(0)>='I' && twoLetter.charAt(0)<='L') {
            gradientObject.setColor(Color.parseColor("#A52A2A"));

    }
        else if(twoLetter.charAt(0)>='M' && twoLetter.charAt(0)<='P') {
            gradientObject.setColor(Color.parseColor("#7FFF00"));

        }
        else if(twoLetter.charAt(0)>='Q' && twoLetter.charAt(0)<='T') {
            gradientObject.setColor(Color.parseColor("#8B008B"));

        }
        else if(twoLetter.charAt(0)>='U' && twoLetter.charAt(0)<='X') {
            gradientObject.setColor(Color.parseColor("#FF1493"));
        }
        else
            gradientObject.setColor(Color.parseColor("#008000"));
    }
}
