package com.example.blacknote_copycat;

import android.provider.ContactsContract;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseInitClass {
   FirebaseDatabase database = FirebaseDatabase.getInstance();
   DatabaseReference ref = database.getReference();

   //DatabaseReference notesRef = ref.child("users");
}
