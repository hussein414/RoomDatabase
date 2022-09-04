package com.example.toolbar;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM T_person")
    List<Person> getAllData();

    @Insert
    void addData( ArrayList<Person> personList );

    @Delete
    void deleteData( Person person );
}
