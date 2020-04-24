package domain;

import java.io.Serializable;
import java.util.List;

public class Order extends AbstractEntity<Long> implements Serializable {
    private Reader reader;
    private Book book;

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return java.util.Objects.equals(reader, order.reader) &&
                java.util.Objects.equals(book, order.book);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), reader, book);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Order{"
                + "id='" + getId()
                + '\''
                + ", reader='"
                + reader
                + '\''
                + ", book='"
                + book
                + '\''
                + '}';
    }
}
