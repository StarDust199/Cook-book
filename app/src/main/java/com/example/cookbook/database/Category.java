package com.example.cookbook.database;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Category {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="categoryName")
    public String categoryName;
}
