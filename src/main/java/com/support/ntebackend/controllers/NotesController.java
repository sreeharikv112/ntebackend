package com.support.ntebackend.controllers;

import com.support.ntebackend.models.Feedback;
import com.support.ntebackend.models.Note;
import com.support.ntebackend.models.NoteBook;
import com.support.ntebackend.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class NotesController {

    @Autowired
    public NoteRepo repo = new NoteRepo();


    @GetMapping("/getallnotebooks")
    public List<NoteBook> getAllNotebook(){
        return repo.retrieveAllNotebooks();
    }

    @GetMapping("/getallnotes")
    public List<Note> getAllNotes(){
        return repo.retrieveAllNotes();
    }

    @PostMapping("/addnote")
    public Note addNewNote(@RequestBody Note note, BindingResult bindingResult)throws  Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("validation ERROR");
        }
        try {
            return repo.addNote(note);
        } catch (Exception e) {
            System.out.println("EXCEP ADD = "+e.toString());
            return null;
        }
    }

    @PostMapping("/addnotebook")
    public NoteBook addNewNoteBook(@RequestBody NoteBook note, BindingResult bindingResult)throws  Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("validation ERROR");
        }
        try {
            return repo.addNotebook(note);

        } catch (Exception e) {
            System.out.println("EXCEP ADD NOTE BOOK = "+e.toString());
            return null;
        }
    }

    @PutMapping("/updatenotebook")
    public boolean updateNoteBook(@RequestBody NoteBook note, BindingResult bindingResult)throws  Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("validation ERROR");
        }
        try {
            return repo.updateNoteBook(note);
        } catch (Exception e) {
            System.out.println("EXCEP UPDATE NOTE BOOK = "+e.toString());
            return false;
        }
    }

    @DeleteMapping("/deletenote")
    public boolean deleteNote(@RequestParam("noteId") int noteId){
        return repo.deleteNote(noteId);
    }

    @DeleteMapping("/deletenotebook")
    public boolean deleteNotebook(@RequestParam("noteId") int noteId)throws  Exception{
        return repo.deleteNotebook(noteId);
    }

    @GetMapping("/getallnotesbyid")
    public List<Note> getAllNotesById(@RequestParam("id") int id){
        return repo.getAllNotesById(id);
    }

    @PostMapping("/feedback")
    public boolean newFeedback(@RequestBody Feedback feedback, BindingResult bindingResult)throws  Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("validation ERROR");
        }
        if(feedback!=null &&
                feedback.getEmail()!=null &&
                feedback.getName()!=null &&
                feedback.getFeedback()!=null &&
                !feedback.getName().isEmpty() &&
                !feedback.getEmail().isEmpty() &&
                !feedback.getFeedback().isEmpty()
                ){
            return true;
        }else{
            return false;
        }
    }

    @PutMapping("/updatenote")
    public boolean updateNote(@RequestBody Note note, BindingResult bindingResult)throws  Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("validation ERROR");
        }
        try {
            return repo.updateNote(note);
        } catch (Exception e) {
            System.out.println("EXCEP UPDATE NOTE = "+e.toString());
            return false;
        }
    }
}
