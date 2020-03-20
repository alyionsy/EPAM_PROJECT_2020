package domain;

import java.io.Serializable;

// we decided to name that class this way
// because name 'reader' is usually used for other types of classes
public class BookOwner extends AbstractEntity<Long> implements Serializable {
    private String bookOwnerName;
    private String bookOwnerSecondName;
    private String bookOwnerNumber;

//    public BookOwner(String bookOwnerName, String bookOwnerSecondName, String bookOwnerNumber) {
//        this.bookOwnerName = bookOwnerName;
//        this.bookOwnerSecondName = bookOwnerSecondName;
//        this.bookOwnerNumber = bookOwnerNumber;
//    }

    public void setBookOwnerName(String bookOwnerName) {
        this.bookOwnerName = bookOwnerName;
    }

    public void setBookOwnerSecondName(String bookOwnerSecondName) {
        this.bookOwnerSecondName = bookOwnerSecondName;
    }

    public void setBookOwnerNumber(String bookOwnerNumber) {
        this.bookOwnerNumber = bookOwnerNumber;
    }

    public String getBookOwnerName() {
        return bookOwnerName;
    }

    public String getBookOwnerSecondName() {
        return bookOwnerSecondName;
    }

    public String getBookOwnerNumber() {
        return bookOwnerNumber;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookOwner bookOwner = (BookOwner) o;
        return java.util.Objects.equals(bookOwnerName, bookOwner.bookOwnerName) &&
                java.util.Objects.equals(bookOwnerSecondName, bookOwner.bookOwnerSecondName) &&
                java.util.Objects.equals(bookOwnerNumber, bookOwner.bookOwnerNumber);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), bookOwnerName, bookOwnerSecondName, bookOwnerNumber);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "BookOwner{" +
                " bookOwnerName=" + bookOwnerName +
                ", bookOwnerSecondName=" + bookOwnerSecondName +
                " bookOwnerNumber=" + bookOwnerNumber +
                '}';
    }
}