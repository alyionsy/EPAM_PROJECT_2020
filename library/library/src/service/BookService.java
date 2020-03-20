package service;

import domain.Book;

public interface BookService {
    Book create(Book book);
    Book update(Book book, String[] params); // params: [0] - name, [1] - author,
                                             // [2] - description
}
