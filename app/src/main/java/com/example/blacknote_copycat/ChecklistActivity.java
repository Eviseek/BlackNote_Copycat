package com.example.blacknote_copycat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChecklistActivity extends AppCompatActivity {

    DialogClass checklistPointDialog = new DialogClass();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.ViewHolder viewHolder;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<String> checklistPoints = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        recyclerView = findViewById(R.id.checklistRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChecklistAdapter(this, checklistPoints);
        recyclerView.setAdapter(adapter);



        TextView checklistTitleView = findViewById(R.id.checkTitle);

        Intent intent = getIntent();

        if (intent.hasExtra("checklistName")){
            String checklistTitle = intent.getStringExtra("checklistName");
            checklistTitleView.setText(checklistTitle);
         }
    }

    public void goToMainActivity(View view){
        onBackPressed();
    }

    public void addPoint(View view){
        checklistPointDialog.checklistActivity = this;
        checklistPointDialog.checklistPointDialog(this);

    }

    public void addChecklistPoint(String point){
        int insertIndex = 0;
        checklistPoints.add(insertIndex, point);
        adapter.notifyItemChanged(insertIndex);
    }
}