package me.bosca.eventsapi.infra.controller;


import jakarta.validation.Valid;
import me.bosca.eventsapi.core.domain.contract.PersonUseCase;
import me.bosca.eventsapi.core.domain.entity.Person;
import me.bosca.eventsapi.core.dto.PersonInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonUseCase personUseCase;

    @PostMapping("/person")
    ResponseEntity<Person> create(@RequestBody @Valid PersonInput person) {
        try {
            Person personCreated = personUseCase.create(person);
            return new ResponseEntity(personCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person")
    ResponseEntity<List<Person>> fetch() {
        try {
            List<Person> persons = personUseCase.fetch();
            return new ResponseEntity(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    ResponseEntity<Person> getByID(@PathVariable int id) {
        try {
            Person person = personUseCase.getByID(id);
            return new ResponseEntity(person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/person/{id}")
    ResponseEntity<Person> update(@PathVariable int id, @RequestBody @Valid PersonInput person) {
        try {
            Person personUpdated = personUseCase.update(id, person);
            return new ResponseEntity(personUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/person/{id}")
    ResponseEntity<Person> delete(@PathVariable int id) {
        try {
            Person person = personUseCase.delete(id);
            return new ResponseEntity(person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

