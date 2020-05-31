package by.mygeekacademy.library.rest.controller;

import by.mygeekacademy.library.domain.Reader;
import by.mygeekacademy.library.service.ReaderService;
import by.mygeekacademy.library.service.impl.ReaderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("api/reader")
@Controller
public class ReaderController {
    private static ReaderService service;

    ReaderController() {
        service = new ReaderServiceImpl();
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Map<String, String> requestBody) {
        Reader reader = new Reader();
        reader.setName(requestBody.get("name"));
        reader.setSecondName(requestBody.get("secondName"));
        service.create(reader);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Reader>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Reader> read(@PathVariable("id") Integer id) {
        Reader reader = service.read(id);

        if (reader != null) {
            return ResponseEntity.ok(reader);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        Reader reader = service.read(id);
        ResponseEntity<String> responseEntity;
        if (reader != null) {
            reader.setName(requestBody.get("name"));
            reader.setSecondName(requestBody.get("secondName"));
            service.update(reader);
            responseEntity = new ResponseEntity<>("Reader (id=" + id + ") was updated.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such readers.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> responseEntity;
        Reader reader = service.read(id);
        if (reader != null) {
            service.delete(reader);
            responseEntity = new ResponseEntity<>("Reader (id=" + id + ") was deleted.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such readers.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
