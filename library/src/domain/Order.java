package domain;

import java.io.Serializable;
import java.util.List;

public class Order extends AbstractEntity<Long> implements Serializable {
    private Reader reader;
    private List<Book> takenBooks;

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setTakenBooks(List<Book> takenBooks) {
        this.takenBooks = takenBooks;
    }

    public Reader getReader() {
        return reader;
    }

    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return java.util.Objects.equals(reader, order.reader) &&
                java.util.Objects.equals(takenBooks, order.takenBooks);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), reader, takenBooks);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Order{"
                + "id='" + getId()
                + '\''
                + ", reader='"
                + reader
                + '\''
                + ", takenBooks='"
                + takenBooks
                + '\''
                + '}';
    }
}
