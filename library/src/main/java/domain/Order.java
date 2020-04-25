package domain;

import java.io.Serializable;
import java.util.Objects;

public class Order extends AbstractEntity<Integer> implements Serializable {
    private int readerID;
    private int bookID;

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return readerID == order.readerID &&
                bookID == order.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), readerID, bookID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", readerID=" + readerID +
                ", bookID=" + bookID +
                '}';
    }
}
