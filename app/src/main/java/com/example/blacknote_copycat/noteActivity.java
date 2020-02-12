package com.example.blacknote_copycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class noteActivity extends AppCompatActivity {

    Button saveBtn;
    String filename, noteTitleStr, noteStr;
    EditText noteEditText, noteTitleEditText;

    float textSize;

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


//        try (FileOutputStream fOut = openFileOutput(filename, Context.MODE_PRIVATE)) {
//            fOut.write(noteTitleStr.getBytes());
//            Log.i("Success", "got dat shit into file");
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.i("Error", "could not write into file");
//        }

    }
}
