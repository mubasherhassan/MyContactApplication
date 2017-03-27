package com.example.zephyr.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Person> person=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        person.add(new Person("Amad Butt","03365002142"));
        person.add(new Person("Azam Khan","03365343434"));
        person.add(new Person("Painter Ali","03465002141"));
        person.add(new Person("Nifasat Ansari","033150342142"));
        person.add(new Person("Zaeem Qadri","03001342141"));
        person.add(new Person("Careem Ali","03165342243"));
        person.add(new Person("Dawood Khan","03465002164"));

        ListAdapter listAdapter=new PersonList(this,person);



        ListView listView1=(ListView) findViewById(R.id.Listviiew1);
        listView1.setAdapter(listAdapter);




        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name= person.get(position).getName();

                Intent detailView=new Intent(MainActivity.this,PersonDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("value", person.get(position));
                detailView.putExtras(bundle);

//                detailView.putExtra("contact", person.get(position));
                startActivity(detailView);
            }

        });



    }


}
