package com.example.cookbook.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Category.class,Products.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ProductsListDao productsListDao();
    public static  AppDataBase INSTANCE;
    public static AppDataBase getDBInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"AppDB").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
