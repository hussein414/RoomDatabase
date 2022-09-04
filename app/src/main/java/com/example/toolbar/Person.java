package com.example.toolbar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Family")
    private String family;

    public Person( String name, String family ) {
        this.name = name;
        this.family = family;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily( String family ) {
        this.family = family;
    }

}
