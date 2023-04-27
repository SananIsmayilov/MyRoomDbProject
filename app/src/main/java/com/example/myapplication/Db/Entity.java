package com.example.myapplication.Db;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity
public class Entity {
    @PrimaryKey (autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "pasvord")
    public String pasvord;

    public Entity (String name,String pasvord){
        this.name=name;
        this.pasvord=pasvord;
    }
}
