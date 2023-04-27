package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Db.DaoClass;
import com.example.myapplication.Db.Entity;
import com.example.myapplication.Db.RoomDbs;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
CompositeDisposable compositeDisposable= new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomDbs roomDbs = Room.databaseBuilder(getApplicationContext(),RoomDbs.class,"Places").allowMainThreadQueries().build();
        DaoClass daoClass = roomDbs.daoClass();
        Entity entity = new Entity("askskl","jfsjs");
        compositeDisposable.add( daoClass.insert(entity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleresponse));


        compositeDisposable.add( daoClass.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleresponse1));
    }
    public void handleresponse(){
        Toast.makeText(this,"jsdsd",Toast.LENGTH_LONG).show();
    }
    public void handleresponse1(List<Entity> entityList){
        //test get all
        for(int i=0;i<entityList.size();i++){
            System.out.println("slam"+entityList.get(i).name);
        }
    }
}