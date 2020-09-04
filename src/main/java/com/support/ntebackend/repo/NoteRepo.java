package com.support.ntebackend.repo;

import com.support.ntebackend.models.Note;
import com.support.ntebackend.models.NoteBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Repository
public class NoteRepo {

    private List<Note> allNotes = new ArrayList();
    private List<NoteBook> allNotebooks = new ArrayList();

    public NoteRepo(){
    }

    public List<NoteBook> retrieveAllNotebooks() {
        return allNotebooks;
    }

    public List<Note> retrieveAllNotes() {
        return allNotes;
    }

    public Note addNote(Note note) throws Exception{
        if(note.getNotebookId()== -1){
            throw new Exception("Notebook ID is invalid");
        }
        note.setId(new Random().nextInt(10000));
        allNotes.add(note);
        return note;
    }

    public NoteBook addNotebook(NoteBook notebook){
        notebook.setNoteId(new Random().nextInt(10000));
        allNotebooks.add(notebook);
        return notebook;
    }

    public boolean updateNoteBook(NoteBook notebook){
        for(int count =0; count <allNotebooks.size(); count++){
            if(allNotebooks.get(count).getNoteId() == notebook.getNoteId()){
                allNotebooks.set(count,notebook);
                return true;
            }
        }
        return false;
    }

   public boolean deleteNote(int noteId){
        boolean isDeleted=false;
        Iterator<Note> itr = allNotes.iterator();
        while(itr.hasNext()){
            Note note = itr.next();
            if (note.getNotebookId() == noteId) {
                itr.remove();
                if(!isDeleted) isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public boolean deleteNotebook(int noteId) {
        boolean isDeleted=false;
        Iterator<NoteBook> noteBookIterator = allNotebooks.iterator();
        while(noteBookIterator.hasNext()){
            NoteBook noteBook = noteBookIterator.next();
            if(noteBook.getNoteId() == noteId){
                Iterator<Note> itr = allNotes.iterator();
                while(itr.hasNext()){
                    Note note = itr.next();
                    if (note.getNotebookId() == noteId) {
                        itr.remove();
                    }
                }
                allNotebooks.remove(noteBook);
                isDeleted=true;
                break;
            }
        }
        return isDeleted;
    }

    public List<Note> getAllNotesById(int id) {
        List<Note> allNotesFiltered = new ArrayList<>();
        for(int count=0;count<allNotes.size();count++){
            if(allNotes.get(count).getNotebookId() == id){
                allNotesFiltered.add(allNotes.get(count));
            }
        }
        return allNotesFiltered;
    }

    public boolean updateNote(Note note){
        for(int count =0; count <allNotes.size(); count++){
            if(allNotes.get(count).getId() == note.getId()){
                allNotes.set(count,new Note(note.getNoteTitle(),note.getNoteDetails(),
                        note.getNotebookId(),note.getId()));
                return true;
            }
        }
        return false;
    }
}
