package com.example.blacknote_copycat;

public class NoteObject {
    private String noteTitle;
    private String note;

    public NoteObject(String noteTitle, String note) {
        this.noteTitle = noteTitle;
        this.note = note;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
