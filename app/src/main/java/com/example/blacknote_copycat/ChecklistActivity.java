package com.example.blacknote_copycat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChecklistActivity extends AppCompatActivity {

    DialogClass checklistPointDialog = new DialogClass();
    private RecyclerView recyclerView;
    private ChecklistAdapter adapter;
    private RecyclerView.ViewHolder viewHolder;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<String> checklistPoints = new ArrayList<>();

    int insertIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        recyclerView = findViewById(R.id.checklistRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChecklistAdapter(this, checklistPoints);
        adapter.checklistActivity = this;
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
        checklistPoints.add(insertIndex, point);
        adapter.notifyItemChanged(insertIndex);

        insertIndex++;
    }

    public void deleteChecklistPoint(int position){
        checklistPoints.remove(position);
        adapter.notifyItemChanged(position);
        adapter.notifyDataSetChanged();


        if (insertIndex > 0) {
            insertIndex--;
        }
    }

    public void getRenamePointPosition(int position){
       // renameChecklistPoint(position);
       //renameChecklistPoint(newxt);
       //get string from dat

        //show dialog
        //get text
        //pass text and pos
        //replace

        checklistPointDialog.checklistPointRenameDialog(this, position);


    }

    public void renameChecklistPoint(int position, String newTxt){
       checklistPoints.set(position, newTxt);
       adapter.notifyItemChanged(position);
    }
}
