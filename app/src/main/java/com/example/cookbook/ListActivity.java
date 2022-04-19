package com.example.cookbook;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookbook.database.Category;
import com.example.cookbook.viewmodel.ListActivtyViewModel;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListActivtyViewModel viewModel;
    private TextView noResulttextView;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setTitle("Product list");
        noResulttextView=findViewById(R.id.noResult);
        recyclerView=findViewById(R.id.recyclerView);
        ImageView addNew=findViewById(R.id.addNewCategoryImageView);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategoryDialog();            }
        });
        initViewModel();
    }
    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void initViewModel(){
    viewModel=new ViewModelProvider(this).get(ListActivtyViewModel.class);
    viewModel.getCategoryListObserver().observe(this, new Observer<List<Category>>() {
        @Override
        public void onChanged(List<Category> categories) {
            if(categories==null){
                noResulttextView.setVisibility(View.VISIBLE);
            }else{
                noResulttextView.setVisibility(View.GONE);
            }}
    });



    }



    private void showAddCategoryDialog(){
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.add_category_layout,null);
        EditText enterCategoryImput=dialogView.findViewById(R.id.enterCategoryImput);
        TextView createButton=dialogView.findViewById(R.id.createButton);
        TextView cancelButton=dialogView.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.dismiss();
            }
        });
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = enterCategoryImput.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(ListActivity.this, "Enter category name", Toast.LENGTH_SHORT).show();
                }
                dialogBuilder.dismiss();
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }




}
