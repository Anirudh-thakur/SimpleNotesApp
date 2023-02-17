package com.notes.notes.controller;
import com.notes.notes.repository.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;
import com.notes.notes.model.*;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesRepository notesRepository;
    public NotesController(NotesRepository notesRepository){
        this.notesRepository = notesRepository;
    }
    // Get all notes 
    @GetMapping
    public List<note> getNotes(){
        return notesRepository.findAll();
    }
    // Add Notes
    @PostMapping
    public ResponseEntity createClient(@RequestBody note n ) throws URISyntaxException {
        note savedNote = notesRepository.save(n);
        return ResponseEntity.created(new URI("/notes/" + savedNote.getId())).body(savedNote);
    }
    // Get Single Note
    @GetMapping("/{id}")
    public note getNote(@PathVariable Long id){
        try{
            System.out.println(id);
            //id = 5;
            System.out.println(id);
            return notesRepository.findById(id).orElseThrow(RuntimeException::new);
        }
        catch(RuntimeException re){
            return null;
        }
    }
    // Update Single Node 
    @PutMapping("/{id}")
    public ResponseEntity updateNote(@PathVariable Long id, @RequestBody note note) {
        note currentNote;
        try{
            System.out.print(id);
            currentNote = notesRepository.findById(id).orElseThrow(RuntimeException::new);
        }
        catch(RuntimeException re){
            return null;
        }

        currentNote.setDescription(note.getDescription());
    
        currentNote = notesRepository.save(note);

        return ResponseEntity.ok(currentNote);
    }
    //Delete Node 
    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable Long id){
        //Long id_converted = Long.parseLong(id);
        notesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    
}
//curl -X POST http://localhost:8080/notes -H "Content-Type: application/json" -d '{"description": "Data Structures HW"}'
