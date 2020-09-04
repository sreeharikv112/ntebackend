package com.support.ntebackend.models;

import org.springframework.lang.NonNull;

import java.util.Random;

public class NoteBook {

    @NonNull
    private String name;

    private int nbNotes;

    private int noteId;

    public NoteBook(){
        super();
    }

    public NoteBook(String name,int nbNotes){
        this.name = name;
        this.nbNotes = nbNotes;
        this.noteId = new Random().nextInt(10000);
    }


    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbNotes() {
        return nbNotes;
    }

    public void setNbNotes(int nbNotes) {
        this.nbNotes = nbNotes;
    }



}
