package domain;

import java.io.Serializable;
import java.util.List;

public class Order extends AbstractEntity<Long> implements Serializable {
    private BookOwner owner;
    private List<Book> takenBooks;

    public Order(BookOwner owner, List<Book> takenBooks) {
        this.owner = owner;
        this.takenBooks = takenBooks; // can be empty
    }

    public void setOwner(BookOwner owner) {
        this.owner = owner;
    }

    public void setTakenBooks(List<Book> takenBooks) {
        this.takenBooks = takenBooks;
    }

    public BookOwner getOwner() {
        return owner;
    }

    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return java.util.Objects.equals(owner, order.owner) &&
                java.util.Objects.equals(takenBooks, order.takenBooks);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), owner, takenBooks);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Order{" +
                "owner=" + owner +
                ", takenBooks=" + takenBooks.toString() +
                '}';
    }
}
