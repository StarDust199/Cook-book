package com.example.cookbook.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cookbook.database.AppDataBase;
import com.example.cookbook.database.Category;

import java.util.List;

public class ListActivtyViewModel extends AndroidViewModel {
    private MutableLiveData<List<Category>> listOfCategory;
    private AppDataBase appDatabase;
    public ListActivtyViewModel(Application application){
        super(application);
        listOfCategory=new MutableLiveData<>();
        appDatabase=AppDataBase.getDBInstance(getApplication().getApplicationContext());
    }
    public MutableLiveData<List<Category>> getCategoryListObserver(){
        return listOfCategory;
    }
    public void getAllCategoryList(){
    List<Category> categoryList= appDatabase.productsListDao().getAllCategoryList();
    if(categoryList.size()>0){
        listOfCategory.postValue(categoryList);
    }else{
        listOfCategory.postValue(null);
    }
    }
    public void insertCategory(String catName){
        Category category=new Category();
        category.categoryName=catName;
        appDatabase.productsListDao().insertCategory(category);
        getAllCategoryList();
    }
    public void updateCategory(Category category){
        appDatabase.productsListDao().updateCategory(category);
        getAllCategoryList();
    }
    public void deleteCatgory(Category category){
        appDatabase.productsListDao().deleteCategory(category);
        getAllCategoryList();;
    }
}
