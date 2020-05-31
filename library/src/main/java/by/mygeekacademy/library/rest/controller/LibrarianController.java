package by.mygeekacademy.library.rest.controller;

import by.mygeekacademy.library.domain.Librarian;
import by.mygeekacademy.library.service.LibrarianService;
import by.mygeekacademy.library.service.impl.LibrarianServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/librarian")
public class LibrarianController {
    private static LibrarianService service;

    LibrarianController() {
        service = new LibrarianServiceImpl();
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Map<String, String> requestBody) {
        Librarian librarian = new Librarian();
        librarian.setUsername(requestBody.get("username"));
        librarian.setPassword(requestBody.get("password"));
        service.create(librarian);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Librarian>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Librarian> read(@PathVariable("id") Integer id) {
        Librarian librarian = service.read(id);

        if (librarian != null) {
            return ResponseEntity.ok(librarian);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        Librarian librarian = service.read(id);
        ResponseEntity<String> responseEntity;
        if (librarian != null) {
            librarian.setUsername(requestBody.get("username"));
            librarian.setPassword(requestBody.get("password"));
            service.update(librarian);
            responseEntity = new ResponseEntity<>("Librarian (id=" + id + ") was updated.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such librarians.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> responseEntity;
        Librarian librarian = service.read(id);
        if (librarian != null) {
            service.delete(librarian);
            responseEntity = new ResponseEntity<>("Librarian (id=" + id + ") was deleted.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such librarians.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
