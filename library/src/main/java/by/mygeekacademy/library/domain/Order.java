package by.mygeekacademy.library.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity<Integer> {
    @Column(name = "readID")
    private int readID;
    @Column(name = "bookID")
    private int bookID;

    public Order() {
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public int getReadID() {
        return readID;
    }

    public void setReadID(int readerID) {
        this.readID = readerID;
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
        return readID == order.readID &&
                bookID == order.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), readID, bookID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", readerID=" + readID +
                ", bookID=" + bookID +
                '}';
    }
}
