package com.example.blacknote_copycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class noteActivity extends AppCompatActivity {

    ImageButton backButton, formatSizeBtn;
    Intent returnToMainAct;

    EditText noteEditText;

    float textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteEditText = findViewById(R.id.noteEditText);
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
}
