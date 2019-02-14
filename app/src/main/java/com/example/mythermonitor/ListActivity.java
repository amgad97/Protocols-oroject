package com.example.mythermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

List<DataItem>lstData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listview=(ListView)findViewById(R.id.linearLayout);
        lstData=new ArrayList<>();
        lstData.add(new DataItem(R.drawable.sql,"sql"));
        lstData.add(new DataItem(R.drawable.java,"java"));
        lstData.add(new DataItem(R.drawable.cplusplus,"C++"));
        lstData.add(new DataItem(R.drawable.csharp,"C#"));

       CustomAdapter adapter=new CustomAdapter(this,R.layout.itemrow,lstData);

       listview.setAdapter(adapter);

       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(ListActivity.this,LastActivity.class);
               startActivity(intent);
               finish();

           }
       });



    }
}
