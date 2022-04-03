package com.example.cookbook.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Products {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="productName")
    public String productName;

    @ColumnInfo(name="categoryId")
    public int categoryId;
}
