package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import  com.example.learnandroidfrom0.ListAdapter.customButtonListener;

public class MainActivity extends AppCompatActivity implements
        customButtonListener {

    private ListView listView;
    ListAdapter adapter;
    ArrayList<String> dataItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dataArray = getResources().getStringArray(R.array.listdata);
        List<String> dataTemp = Arrays.asList(dataArray);
        dataItems.addAll(dataTemp);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ListAdapter(MainActivity.this, dataItems);
        adapter.setCustomButtonListner(MainActivity.this);
        listView.setAdapter(adapter);

    }

    @Override
    public void onButtonClickListner(int position, String value) {
        Toast.makeText(MainActivity.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        dataItems.remove(position);
        adapter.notifyDataSetChanged();
    }

}