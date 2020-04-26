package com.example.blacknote_copycat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    Integer position = 0;

    final ArrayList<String> notes = new ArrayList<>();


    FirebaseInitClass firebaseInitClass = new FirebaseInitClass();


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");

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

//        animalNames.add("Horse");
//        animalNames.add("Cow");
//        animalNames.add("Camel");
//        animalNames.add("Sheep");
//        animalNames.add("Goat");
//        animalNames.add("Camel");
//        animalNames.add("Sheep");
//        animalNames.add("Goat2");
//        animalNames.add("Camel");
//        animalNames.add("Sheep2");
//        animalNames.add("Goat1");

 //       firebaseInitClass.notesRef.setValue(animalNames);

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("notes");
//
//        reference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String noteTitle = dataSnapshot.child("noteTitle").getValue().toString();
//                Log.i("title", noteTitle);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        ValueEventListener notesListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Note note = dataSnapshot.getValue(Note.class);
//
//
//                if (dataSnapshot.hasChild("notes")){
//                    String title = String.valueOf(dataSnapshot.child("noteTitle"));
//                    Log.i("title", title);
//                } else {
//                    Log.i("title", "nothing found");
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.w("onCancelled", databaseError.toException());
//            }
//        };

       // Log.i("0 pos in list:", animalNames.get(0));

      //  firebaseInitClass.ref.addValueEventListener(notesListener);


        //nacita se prvne recycler a az pak databaze omg

        loadNotesFromDatabase();

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainActivityAdapter(this, notes);
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

    public void loadNotesFromDatabase(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("notes");
        reference.child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                //while (dataSnapshot.hasChild(String.valueOf(position))) { //v tomhle je nekde chyba oprav to omg
                    notes.add(position, (String.valueOf(dataSnapshot.child("noteTitle").getValue())));
                    String title = String.valueOf(dataSnapshot.child("noteTitle").getValue());
                    Log.i("title", title);
                    Log.i("notes", notes.get(0));
                    position++;
               // }

                layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new MainActivityAdapter(getApplicationContext(), notes);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
