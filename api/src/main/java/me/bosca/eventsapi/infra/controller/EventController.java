package me.bosca.eventsapi.infra.controller;


import jakarta.validation.Valid;
import me.bosca.eventsapi.core.domain.contract.EventUseCase;
import me.bosca.eventsapi.core.domain.entity.Event;
import me.bosca.eventsapi.core.dto.EventInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventUseCase eventUseCase;

    @PostMapping("/event")
    ResponseEntity<Event> create(@RequestBody @Valid EventInput event) {
        try {
            Event eventCreated = eventUseCase.create(event);
            return new ResponseEntity(eventCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/event")
    ResponseEntity<List<Event>> fetch() {
        try {
            List<Event> events = eventUseCase.fetch();
            return new ResponseEntity(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/event/{id}")
    ResponseEntity<Event> getByID(@PathVariable int id) {
        try {
            Event event = eventUseCase.getByID(id);
            return new ResponseEntity(event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/event/{id}")
    ResponseEntity<Event> update(@PathVariable int id, @RequestBody @Valid EventInput event) {
        try {
            Event eventUpdated = eventUseCase.update(id, event);
            return new ResponseEntity(eventUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/event/{id}")
    ResponseEntity<Event> delete(@PathVariable int id) {
        try {
            Event event = eventUseCase.delete(id);
            return new ResponseEntity(event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

