package com.example.cookbook.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductsListDao {
    @Query("Select * from Products")
    List<Products> getAllProductsList();
    List<Category> getAllCategoryList();
    @Insert
    void insertProduct(Products...products);
    @Update
    void updateProduct(Products products);
    @Delete
    void deleteProduct(Products products);
    @Insert
    void insertCategory(Category...categories);
    @Update
    void updateCategory(Category categories);
    @Delete
    void deleteCategory(Category categories);
}
