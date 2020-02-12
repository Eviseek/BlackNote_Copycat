package com.example.blacknote_copycat;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public addDialogClass addDialogClass = new addDialogClass();
    ImageButton addBtn, searchBtn, favoritesBtn, checklistBtn, categoryBtn, sortBtn, optionsBtn;
    Dialog addDialog;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDialog = addDialogClass.onCreateDialog(this);

        recyclerView = findViewById(R.id.recyclerView);
        addBtn = findViewById(R.id.addBtn);
        searchBtn = findViewById(R.id.searchBtn);
        favoritesBtn = findViewById(R.id.favBtn);
        checklistBtn = findViewById(R.id.dailyCheckBtn);
        categoryBtn = findViewById(R.id.categoryBtn);
        sortBtn = findViewById(R.id.sortBtn);
        optionsBtn = findViewById(R.id.optionsBtn);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(this, animalNames);
        recyclerView.setAdapter(adapter);

    }

    public void addNew(View view){
        addDialog.show();

    }
}
