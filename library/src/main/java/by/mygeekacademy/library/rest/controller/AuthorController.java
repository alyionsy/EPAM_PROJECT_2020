package by.mygeekacademy.library.rest.controller;

import by.mygeekacademy.library.domain.Author;
import by.mygeekacademy.library.service.AuthorService;
import by.mygeekacademy.library.service.impl.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("api/author")
@Controller
public class AuthorController {
    private static AuthorService service;

    AuthorController() {
        service = new AuthorServiceImpl();
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Map<String, String> requestBody) {
        Author author = new Author();
        author.setName(requestBody.get("name"));
        author.setSecondName(requestBody.get("secondName"));
        service.create(author);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Author>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> read(@PathVariable("id") Integer id) {
        Author author = service.read(id);

        if (author != null) {
            return ResponseEntity.ok(author);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        Author author = service.read(id);
        ResponseEntity<String> responseEntity;
        if (author != null) {
            author.setName(requestBody.get("name"));
            author.setSecondName(requestBody.get("secondName"));
            service.update(author);
            responseEntity = new ResponseEntity<>("Author (id=" + id + ") was updated.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such authors.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> responseEntity;
        Author author = service.read(id);
        if (author != null) {
            service.delete(author);
            responseEntity = new ResponseEntity<>("Author (id=" + id + ") was deleted.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such authors.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
