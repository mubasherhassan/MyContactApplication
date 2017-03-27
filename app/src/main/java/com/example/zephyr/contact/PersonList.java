package com.example.zephyr.contact;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zephyr on 3/21/2017.
 */

public class PersonList extends ArrayAdapter<Person> {



    public PersonList(Context context, ArrayList<Person> resource) {

        super(context, R.layout.custom_row,resource);
    }


    private  void twoLetter(){

    }

    String singleName,twoCharacter;
    TextView twoLetter;
    TextView listName,contactNumber;
    GradientDrawable gradientObject;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater changeListView=LayoutInflater.from(getContext());
        View customView=changeListView.inflate(R.layout.custom_row,parent,false);

        twoLetter=(TextView)customView.findViewById(R.id.resulttext);
        listName=(TextView)customView.findViewById(R.id.textView);
        contactNumber=(TextView)customView.findViewById(R.id.contactNumberView);
        TextView listImage=(TextView) customView.findViewById(R.id.resultImage);


        singleName=getItem(position).getName();
        contactNumber.setText(""+getItem(position).getContactNo());
        twoCharacter=singleName;
        listName.setText(twoCharacter);


        twoLetter.setText(splitName());
       // listImage.setImageResource(R.drawable.circle);

        gradientObject = (GradientDrawable)listImage.getBackground();


        setColor();
        return  customView;
    }
    private  void setColor(){
        if(twoCharacter.charAt(0)>='A' && twoCharacter.charAt(0)<='D') {
            gradientObject.setColor(Color.parseColor("#00FFFF"));

        }
        else if(twoCharacter.charAt(0)>='E' && twoCharacter.charAt(0)<='H') {
            gradientObject.setColor(Color.parseColor("#8A2BE2"));

        }else if(twoCharacter.charAt(0)>='I' && twoCharacter.charAt(0)<='L') {
            gradientObject.setColor(Color.parseColor("#A52A2A"));

        }
        else if(twoCharacter.charAt(0)>='M' && twoCharacter.charAt(0)<='P') {
            gradientObject.setColor(Color.parseColor("#7FFF00"));

        }
        else if(twoCharacter.charAt(0)>='Q' && twoCharacter.charAt(0)<='T') {
            gradientObject.setColor(Color.parseColor("#8B008B"));

        }
        else if(twoCharacter.charAt(0)>='U' && twoCharacter.charAt(0)<='X') {
            gradientObject.setColor(Color.parseColor("#FF1493"));
        }
        else
            gradientObject.setColor(Color.parseColor("#008000"));
    }

    private  String splitName(){
        String[] words=singleName.split(" ");//splits the string based on whitespace
        //using java foreach loop to print elements of string array
        String twchar="";
        for(String w:words){
            twchar+=w.charAt(0);
        }
        return  twchar;
    }
}
