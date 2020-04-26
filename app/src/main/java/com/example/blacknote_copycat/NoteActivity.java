package com.example.blacknote_copycat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.blacknote_copycat.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

import static java.sql.Types.NULL;

public class NoteActivity extends AppCompatActivity {

    Button saveBtn;
    String filename, noteTitleStr, noteStr;
    EditText noteEditText, noteTitleEditText;
    float textSize;
    Integer position = 0;

    User user = new User();

    FirebaseInitClass firebaseInitClass = new FirebaseInitClass();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        saveBtn = findViewById(R.id.saveNoteButton);
        noteEditText = findViewById(R.id.noteEditText);
        noteTitleEditText = findViewById(R.id.noteTitleEditText);
        textSize = noteEditText.getTextSize();

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (user != null){
                    userId = firebaseUser.getUid();
                    Log.d("user id", userId);
                } else {
                    Log.d("firebase", "signed_out");
                }
            }
        };

    }

    public void goToMainActivity(View view){
        onBackPressed();
    }

    public void formatTextSize(View view){
        textSize = textSize + 10;
        noteEditText.setTextSize(textSize);

        if (textSize > 50){
           textSize = 10;
        }
    }

    public void saveNote(View view){

        user.setNoteText(String.valueOf(noteEditText.getText()));
        user.setNoteTitle(String.valueOf(noteTitleEditText.getText()));

        firebaseInitClass.ref.child("users").child(userId).setValue(user.getNoteText());
        firebaseInitClass.ref.child("users").child(userId).setValue(user.getNoteTitle());


        position++;


        onBackPressed();
    }

    public void loadNotesFromDatabase(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    User user = new User();
                 //   user.setNotes(ds.child(userId).getValue(User.class).getNotes().get(position));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
