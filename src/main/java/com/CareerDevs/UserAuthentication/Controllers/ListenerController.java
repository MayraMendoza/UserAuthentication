package com.CareerDevs.UserAuthentication.Controllers;

import com.CareerDevs.UserAuthentication.models.Listener;
import com.CareerDevs.UserAuthentication.repositories.ListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/listeners") //default" "/api/{plural entity name}'
public class ListenerController {

    @Autowired
    private ListenerRepository listenerRepository;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute(){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
    // Create, Read , update , Delete
    // Create = POST
    // Read = GET (url)
    // Update = Post(more commonly used) PUT*  (expects a body)
    // Delete = DELETE (url)

    // create a listener profile
    @PostMapping("/")
    public ResponseEntity<Listener> createLister(@RequestBody Listener newListener ){
        Listener listener = listenerRepository.save(newListener);
        return new ResponseEntity<>(listener, HttpStatus.CREATED);

    }
    //get all listeners
    @GetMapping("/")
    public ResponseEntity<List<Listener>> getAllListeners(){
        List<Listener> listeners=  listenerRepository.findAll();
        return new ResponseEntity<>(listeners, HttpStatus.OK);
    }

    //get one listener
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneListener(@PathVariable Long id){
//       Listener listener = listenerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Optional<Listener> maybeListener = listenerRepository.findById(id);

        if(maybeListener.isEmpty()){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maybeListener.get(), HttpStatus.OK);
    }
}
