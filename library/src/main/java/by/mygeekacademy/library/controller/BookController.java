package by.mygeekacademy.library.controller;

import by.mygeekacademy.library.domain.Book;
import by.mygeekacademy.library.service.BookService;
import by.mygeekacademy.library.service.impl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("api/book")
@Controller
public class BookController {
    private static BookService service;

    BookController() {
        service = new BookServiceImpl();
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Map<String, String> requestBody) {
        Book book = new Book();
        book.setName(requestBody.get("name"));
        book.setAuthorID(Integer.parseInt(requestBody.get("authorID")));
        book.setYear(Integer.parseInt(requestBody.get("year")));
        book.setDescription(requestBody.get("description"));
        service.create(book);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> read(@PathVariable("id") Integer id) {
        Book book = service.read(id);

        if (book != null) {
            return ResponseEntity.ok(book);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        Book book = service.read(id);
        ResponseEntity<String> responseEntity;
        if (book != null) {
            book.setName(requestBody.get("name"));
            book.setAuthorID(Integer.parseInt(requestBody.get("authorID")));
            book.setYear(Integer.parseInt(requestBody.get("year")));
            book.setDescription(requestBody.get("description"));
            service.update(book);
            responseEntity = new ResponseEntity<>("Book (id=" + id + ") was updated.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such books.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> responseEntity;
        Book book = service.read(id);
        if (book != null) {
            service.delete(book);
            responseEntity = new ResponseEntity<>("Book (id=" + id + ") was deleted.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such books.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
