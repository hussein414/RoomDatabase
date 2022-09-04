package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    EditText name, family;
    Button save;
    RecyclerView recyclerView;
    PersonDatabase database;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.editTextTextPersonName);
        family = findViewById(R.id.editTextTextPersonFamily);
        save = findViewById(R.id.saveButton);
        recyclerView = findViewById(R.id.recyclerView);
        setRecyclerView();
        save.setOnClickListener(v -> {
            setNewPerson(name.getText().toString(), family.getText().toString());
            setRecyclerView();
        });
    }

    private void setRecyclerView() {
        database=PersonDatabase.getInstance(getApplicationContext());
        List<Person> list=database.personDao().getAllData();
        PersonAdapter adapter=new PersonAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void setNewPerson( String name, String family ) {
        database = PersonDatabase.getInstance(getApplicationContext());
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(name, family));
        database.personDao().addData(list);
    }
}