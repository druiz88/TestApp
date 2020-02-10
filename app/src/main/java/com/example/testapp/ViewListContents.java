package com.example.testapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.database.Cursor;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        myDB = new DatabaseHelper(this);

        userList = new ArrayList<>();

        Cursor data = myDB.getListContents();
        int numRows = data.getCount();

        if(numRows == 0){
            Toast.makeText(ViewListContents.this,"Void!", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                user = new User(data.getInt(0),data.getString(1),data.getString(2),data.getString(3));
                userList.add(user);
            }
            ThreeColumn_ListAdapter adapter =  new ThreeColumn_ListAdapter(this,R.layout.list_adapter_view, userList);
            listView = findViewById(R.id.listView);

            listView.setAdapter(adapter);
        }
    }
}
