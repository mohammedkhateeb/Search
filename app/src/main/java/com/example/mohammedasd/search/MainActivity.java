package com.example.mohammedasd.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


import android.os.Bundle;

import android.text.Editable;

import android.text.TextWatcher;

import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.ListView;

import java.util.ArrayList;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    String[] items;

    ArrayList<String> listItems;

    ArrayAdapter<String> adapter;

    ListView listView;

    EditText editText;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        editText=(EditText)findViewById(R.id.txtsearch);

        initList();

        editText.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {



            }



            @Override

            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {

                if(s.toString().equals("")){

                    // reset listview

                    initList();

                }

                else{

                    // perform search

                    searchItem(s.toString());

                }

            }



            @Override

            public void afterTextChanged(Editable s) {



            }

        });

    }



    public void searchItem(String textToSearch){

        for(String item:items){

            if(!item.contains(textToSearch)){

                listItems.remove(item);

            }

        }

        adapter.notifyDataSetChanged();

    }

    public void initList(){

        items=new String[]{"Ali","Ahmed","Omar","mohammed"};

        listItems=new ArrayList<>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.txtitem, listItems);

        listView.setAdapter(adapter);

    }

}







