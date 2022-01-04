package com.milople.mydemoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.milople.mydemolibrary.Toastermessage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button save,refresh,delete;
    RecyclerView recbtn;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList array_list1;
    List<Btnmodel> btnmodelList=new ArrayList<>();
    List<Integer> array_list=new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<Integer>();
    Intent intent;String no;int c=101,count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("jsdjf","dkf");
        Init();
        HandleEvent();
        Toastermessage.toasty(this,"HELLO");
        intent=getIntent();
        no=intent.getStringExtra("qty");
        //Log.e("no ",no);
        LocalBroadcastManager.getInstance(this).registerReceiver(msgreceiver,new IntentFilter("message"));
        for(int i=0;i<Integer.parseInt(no);i++){
            btnmodelList.add(new Btnmodel(c,count));
            c++;count++;
        }
        Btnadapter adapter=new Btnadapter(getApplicationContext(),btnmodelList);
        recbtn.setAdapter(adapter);
        recbtn.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recbtn.setItemAnimator(new DefaultItemAnimator());
        adapter.notifyDataSetChanged();                arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);

        Log.e("list",list+"");
        Toastermessage.toasty(this,"HELLO");
    }
    private void HandleEvent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                refresh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int get=position;
                        list.add(position, 5);
                        list.remove(position+1);
                        Toast.makeText(getApplicationContext(), "value updated", Toast.LENGTH_SHORT).show();
                        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(arrayAdapter);
                        Log.e("rmove",list+"");
                    }
                });

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.remove(position);
                        listView.setAdapter(arrayAdapter);
                        Log.e("rmove",list+"");
                    }
                });
            }
        });
    }
    public BroadcastReceiver msgreceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int pos=intent.getIntExtra("pos",0);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.add(pos);
                    arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
                    listView.setAdapter(arrayAdapter);
                }
            });
        }
    };
    private void Init() {
        recbtn=findViewById(R.id.recbtn);
        save=findViewById(R.id.save);
        refresh=findViewById(R.id.refresh);
        delete=findViewById(R.id.delete);
        listView=findViewById(R.id.listView);
    }
}