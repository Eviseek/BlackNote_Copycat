package com.example.blacknote_copycat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;

public class addDialogClass extends DialogFragment {

    public Dialog onCreateDialog(final Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
            builder.setItems(R.array.addDialogItems, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0){
                        //Note
                        Intent createNote = new Intent(context, noteActivity.class);
                        context.startActivity(createNote);
                    }
                    if (which == 1){
                        //Checklist
                        Intent createChecklist = new Intent(context, noteActivity.class);
                        //start activity
                    }
                }
            });


            AlertDialog dialog = builder.create();
            return dialog;
    }
}
