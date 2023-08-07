package com.harmyFounder.harmyWorld.controllers;

import com.harmyFounder.harmyWorld.models.Note;
import com.harmyFounder.harmyWorld.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public List<Note> getAll(){
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public Note getCertain(@PathVariable("id") Note note){
        return note;
    }

    @PostMapping("/getByTag")
    public List<Note> gteByTag(@RequestParam String filter){
        return noteService.getByTag(filter);
    }

    @PostMapping("/new")
    public Note createNote(@RequestBody Note note){
        return noteService.create(note);
    }

    @PutMapping("/{id}/edit")
    public Note updateNote(@PathVariable("id") Note noteToBeUpdated, @RequestBody Note updatedNote){
        return noteService.update(noteToBeUpdated, updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Note note){
        noteService.delete(note);
    }

}
