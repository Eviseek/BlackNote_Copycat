package com.example.blacknote_copycat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogClass extends DialogFragment {

    public ChecklistActivity checklistActivity;

    public Dialog onCreateDialog(final Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
            builder.setItems(R.array.addDialogItems, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0){
                        //Note
                        Intent createNote = new Intent(context, NoteActivity.class);
                        context.startActivity(createNote);
                    }
                    if (which == 1){
                        //Checklist
                        setTitleDialog(context);
                    }
                }
            });


            AlertDialog dialog = builder.create();
            return dialog;
    }


    private void setTitleDialog(final Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        final EditText titleInput = new EditText(context);
        titleInput.setHint("Title");
        dialog.setView(titleInput);

        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String checklistTitle = titleInput.getText().toString();

                Intent createChecklist = new Intent(context, ChecklistActivity.class);
                createChecklist.putExtra("checklistName", checklistTitle);
                context.startActivity(createChecklist);
            }
        });

        dialog.show();
    }


    public void checklistPointDialog(final Context context){
        final String point = "Hello";
        AlertDialog.Builder checklistDialog = new AlertDialog.Builder(context);
        final EditText pointEditText = new EditText(context);
        pointEditText.setHint("Add point");
        checklistDialog.setView(pointEditText);

        checklistDialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checklistActivity.addChecklistPoint(String.valueOf(pointEditText.getText()));
            }
        });

        checklistDialog.show();
        
    }
}
