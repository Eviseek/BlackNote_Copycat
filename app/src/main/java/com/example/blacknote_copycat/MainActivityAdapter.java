package com.example.blacknote_copycat;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;



    // data is passed into the constructor
     MainActivityAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_menu, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String noteTitle = mData.get(position);
        holder.myTextView.setText(noteTitle);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageButton favoriteCardBtn;
        boolean isPressed = false;

        ViewHolder(View itemView) {
            super(itemView);


            myTextView = itemView.findViewById(R.id.tvNoteTitle);
            favoriteCardBtn = itemView.findViewById(R.id.favoriteCardBtn);

            favoriteCardBtn.setTag(4);

            favoriteCardBtn.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getTag() == favoriteCardBtn.getTag()){
                int position = getAdapterPosition();

                if (!isPressed){
                    // pressed state
                    isPressed = true;
                    favoriteCardBtn.setImageResource(R.drawable.outline_favorite_white_48);

                } else {
                    //not pressed state
                    isPressed = false;
                    favoriteCardBtn.setImageResource(R.drawable.outline_favorite_border_white_48);
                }
            }
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
