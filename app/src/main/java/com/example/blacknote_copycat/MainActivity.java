package com.example.blacknote_copycat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public DialogClass DialogClass = new DialogClass();
    ImageButton addBtn, searchBtn, favoritesBtn, checklistBtn, categoryBtn, sortBtn, optionsBtn;
    Dialog addDialog;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    NoteActivity noteActivity = new NoteActivity();
    List notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
          //  notesList = noteActivity.getSharedPref();
        } catch (Exception e){
            Log.i("Error", "not possible");
        }

        addDialog = DialogClass.onCreateDialog(this);

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
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainActivityAdapter(this, animalNames);
        recyclerView.setAdapter(adapter);

    }

    public void addNew(View view){
        addDialog.show();

    }

    public void goToSearchActivity(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void goToFavoritesActivity(View view){
        Intent intent = new Intent(this, FavoritesActivity.class);
        startActivity(intent);
    }
}
