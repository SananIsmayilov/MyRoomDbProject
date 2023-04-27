package com.example.myapplication.Db;

import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface DaoClass {
    @Query("SELECT * FROM Entity")
    Flowable<List<Entity>> getAll();

    @Insert
    Completable insert(Entity entity);
}
