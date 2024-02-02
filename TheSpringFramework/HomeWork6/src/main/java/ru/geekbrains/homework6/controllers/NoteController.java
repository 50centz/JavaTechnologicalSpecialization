package ru.geekbrains.homework6.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework6.models.Note;
import ru.geekbrains.homework6.repository.NoteRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){

        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAllNote(){
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Long id){
        Note note;
        try {
            note = noteRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note){
        Note note1;
        try {
            note1 = noteRepository.findById(id).orElseThrow();
            note1.setContent(note.getContent());
            note1.setHeader(note.getHeader());
            noteRepository.save(note1);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deketeNote(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}