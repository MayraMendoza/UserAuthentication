package com.CareerDevs.UserAuthentication.Controllers;

import com.CareerDevs.UserAuthentication.models.Listener;
import com.CareerDevs.UserAuthentication.models.Note;
import com.CareerDevs.UserAuthentication.repositories.ListenerRepository;
import com.CareerDevs.UserAuthentication.repositories.NoteRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ListenerRepository listenerRepository;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute(){
        return new ResponseEntity<>("note route", HttpStatus.OK);
    }

    // create a note by listener
    @PostMapping("/{listenerId}")
    public ResponseEntity<?> createNote(@PathVariable Long listenerId, @RequestBody Note newNote){
        // TODO validate the listener id is an actual listener
        Listener listener = listenerRepository.findById(listenerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        newNote.setlistener(listener);
        Note note =noteRepository.save(newNote);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    // get all notes
    @GetMapping("/")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteRepository.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }

    //Get note by id
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(note, HttpStatus.OK);

    }
    // get all notes a specific listener made
    @GetMapping("/listener/{listenerId}")
    public ResponseEntity<List<Note>> getNotesByListener(@PathVariable Long listenerId){
        List<Note> notes = noteRepository.findAllBylistener_id(listenerId);
        return  new ResponseEntity<>(notes, HttpStatus.OK);

    }
}
