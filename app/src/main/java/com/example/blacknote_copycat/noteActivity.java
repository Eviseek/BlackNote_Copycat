package com.example.blacknote_copycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class noteActivity extends AppCompatActivity {

    Button saveBtn;
    String filename, noteTitleStr, noteStr;
    EditText noteEditText, noteTitleEditText;
    float textSize;
    NoteObject noteObject = new NoteObject();
    String json;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        filename = "myfile";

        saveBtn = findViewById(R.id.saveNoteButton);
        noteEditText = findViewById(R.id.noteEditText);
        noteTitleEditText = findViewById(R.id.noteTitleEditText);
        textSize = noteEditText.getTextSize();

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
        //save note
        //internal storage
        noteTitleStr = String.valueOf(noteTitleEditText.getText());
        noteStr = String.valueOf(noteEditText.getText());
        noteObject.setNote(noteStr);
        noteObject.setNoteTitle(noteTitleStr);

        addToSharedPref();
        getSharedPref();

        onBackPressed();
    }

    public void addToSharedPref(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        gson = new Gson();
        json = gson.toJson(noteObject);
        editor.putString("NoteObject", json);
        editor.apply();

       // Type type = new TypeToken<List<NoteObject>>(){}.getType();
       // List<NoteObject> notesList = gson.fromJson(json, type);
    }

    public void getSharedPref(){
//        Type type = new TypeToken<List<NoteObject>>(){}.getType();
//        List<NoteObject> notesList = gson.fromJson(json, type);

//        return notesList;

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        Gson gson = new Gson();
        String json = appSharedPrefs.getString("NoteObject", "");
        NoteObject noteObject = gson.fromJson(json, NoteObject.class);

        Log.i("My note", noteObject.getNote());
    }
}
