package by.mygeekacademy.library.rest.controller;

import by.mygeekacademy.library.domain.Order;
import by.mygeekacademy.library.service.OrderService;
import by.mygeekacademy.library.service.impl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private static OrderService service;

    OrderController() {
        service = new OrderServiceImpl();
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Map<String, String> requestBody) {
        Order order = new Order();
        order.setBookID(Integer.parseInt(requestBody.get("bookID")));
        order.setReadID(Integer.parseInt(requestBody.get("readID")));
        service.create(order);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> read(@PathVariable("id") Integer id) {
        Order order = service.read(id);

        if (order != null) {
            return ResponseEntity.ok(order);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        Order order = service.read(id);
        ResponseEntity<String> responseEntity;
        if (order != null) {
            order.setBookID(Integer.parseInt(requestBody.get("bookID")));
            order.setReadID(Integer.parseInt(requestBody.get("readID")));
            service.update(order);
            responseEntity = new ResponseEntity<>("Order (id=" + id + ") was updated.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such orders.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> responseEntity;
        Order order = service.read(id);
        if (order != null) {
            service.delete(order);
            responseEntity = new ResponseEntity<>("Order (id=" + id + ") was deleted.", HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>("No such orders.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
