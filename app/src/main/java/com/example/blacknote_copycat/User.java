package com.example.blacknote_copycat;

import java.util.ArrayList;

public class User {
    String username;
    String noteTitle;
    String noteText;

    public User(String username, String noteTitle, String noteText) {
        this.username = username;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
// ArrayList<Note> notes = new ArrayList<>();

    public User(String username, Integer userId) {
        this.username = username;
     //   this.notes = notes;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public ArrayList<Note> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(ArrayList<Note> notes) {
//        this.notes = notes;
//    }
}
