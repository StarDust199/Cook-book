package com.example.cookbook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookbook.database.Category;

import java.util.List;

public  class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {
   private Context context;
    private List<Category> categoryList;
   public CategoryListAdapter(Context context){
       this.context=context;
   }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
