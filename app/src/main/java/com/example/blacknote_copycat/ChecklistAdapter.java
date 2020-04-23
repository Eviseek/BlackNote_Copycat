//to do

//on button click get id, pass id, delete item with dat id
//on checkbox checked set different color of words


package com.example.blacknote_copycat;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder> {

    public ChecklistActivity checklistActivity;

    private List<String> mData;
    private LayoutInflater mInflater;
    private ChecklistAdapter.ItemClickListener mClickListener;
    // data is passed into the constructor
    ChecklistAdapter(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ChecklistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_checklist, parent, false);
        return new ChecklistAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ChecklistAdapter.ViewHolder holder, int position) {
        String checklistPoint = mData.get(position);
        holder.myPointCheckbox.setText(checklistPoint);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CheckBox myPointCheckbox;
        ImageButton deletePointBtn;
        ImageButton renamePointBtn;



        ViewHolder(final View itemView) {
            super(itemView);

            myPointCheckbox = itemView.findViewById(R.id.checklistPoint);
            deletePointBtn = itemView.findViewById(R.id.deletePointBtn);
            renamePointBtn = itemView.findViewById(R.id.renamePointBtn);

            myPointCheckbox.setTag(1);
            deletePointBtn.setTag(2);
            renamePointBtn.setTag(3);

            deletePointBtn.setOnClickListener(this);
            renamePointBtn.setOnClickListener(this);
            myPointCheckbox.setOnClickListener(this);

        }

        public void onClick(View view){
            int position = getAdapterPosition();


            if (view.getTag() == myPointCheckbox.getTag()){
                Log.i("checkbox clicked", String.valueOf(position));


            } else if (view.getTag() == renamePointBtn.getTag()){
                Log.i("rename clicked", String.valueOf(position));


            } else if (view.getTag() == deletePointBtn.getTag()){
                Log.i("delete clicked", String.valueOf(position));
                checklistActivity.deleteChecklistPoint(position);

            }
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ChecklistAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
