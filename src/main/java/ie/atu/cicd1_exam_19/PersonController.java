package ie.atu.cicd1_exam_19;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonController {


private final PersonService service;
public PersonController(PersonService service){
    this.service=service;
}

@GetMapping
public ResponseEntity<List<Person>> getAll(){
    return ResponseEntity.ok(service.findAll());
}

@GetMapping("/{id}")            //("/{ticketCode}")
public ResponseEntity <Person> getByTicketCode(@PathVariable String ticketCode){
    Optional <Person> maybe = service.findById(ticketCode);
    if(maybe.isPresent()) {
        return ResponseEntity.ok(maybe.get());
    } else {
    return ResponseEntity.notFound().build();
        }

@PostMapping
        public ResponseEntity <Person>create(@Valid @RequestBody Person p){
        Person created = service.create(p);
        return ResponseEntity.created(URI.create("api/person/" + created.getPerson()))
                .body(created);
        }
//@PutMapping("/{}")
@PutMapping("/{ticketCode}")            //("/{ticketCode}")")
    public ResponseEntity <Optional<Person>>
        update Person (@Valid @RequestBody Person update, @PathVariable String ticketCode)
    throws Exception {
        update.setPerson(ticketCode);
        Optional <Person> PersonFound = service.findById(ticketCode);
        if(PersonFound.isPresent()) {
            Person PersonUpdated = PersonFound.get(); // service.update(update);
            return ResponseEntity.ok(PersonUpdated);
        }else{
        return ResponseEntity.notFound().build();
            }
        }
    @DeleteMapping("/{ticketCode}")
            public ResponseEntity<Person> deletePerson (@PathVariable String ticketCode)
    service.findById(ticketCode);
    Optional<Person> PersonFound = service.findById(ticketCode);
    if(PersonFound.isPresent()) {
        Person PersonDeleted = service.deletePerson(personFound.get());
        return ResponseEntity.ok(PersonFound.get());
    }



    }
}


