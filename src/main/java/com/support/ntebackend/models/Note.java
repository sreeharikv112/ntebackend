package com.support.ntebackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Note {

    @JsonProperty("noteTitle")
    private String noteTitle;
    @JsonProperty("noteDetails")
    private String noteDetails;
    @JsonProperty("notebookId")
    private int notebookId;
    @JsonProperty("id")
    private int id;

    @JsonProperty("latemodifieddate")
    private String latemodifieddate;

    public Note(){
        super();
    }
    public Note(String noteTitle, String noteDetails,int bookId) {
        this.noteTitle = noteTitle;
        this.noteDetails = noteDetails;
        this.notebookId =bookId;
        this.id = new Random().nextInt(100000);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        this.latemodifieddate = formatter.format(new Date());
    }

    public Note(String noteTitle, String noteDetails,int bookId,int noteId) {
        this.noteTitle = noteTitle;
        this.noteDetails = noteDetails;
        this.notebookId =bookId;
        this.id = noteId;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        this.latemodifieddate = formatter.format(new Date());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(int notebookId) {
        this.notebookId = notebookId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }
}
