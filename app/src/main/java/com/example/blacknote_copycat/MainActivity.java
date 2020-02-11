package com.example.blacknote_copycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public addDialogClass addDialogClass = new addDialogClass();

    ImageButton addBtn, searchBtn, favoritesBtn, checklistBtn, categoryBtn, sortBtn, optionsBtn;

    Dialog addDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDialog = addDialogClass.onCreateDialog(savedInstanceState, this);

        addBtn = findViewById(R.id.addBtn);
        searchBtn = findViewById(R.id.searchBtn);
        favoritesBtn = findViewById(R.id.favBtn);
        checklistBtn = findViewById(R.id.dailyCheckBtn);
        categoryBtn = findViewById(R.id.categoryBtn);
        sortBtn = findViewById(R.id.sortBtn);
        optionsBtn = findViewById(R.id.optionsBtn);

    }

    public void addNew(View view){
        addDialog.show();
    }
}
