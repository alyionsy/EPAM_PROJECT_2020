package domain;

import java.io.Serializable;

// we decided to name that class this way
// because name 'reader' is usually used for other types of classes
public class BookOwner extends AbstractEntity<Long> implements Serializable {
    private String bookOwnerName;
    private String bookOwnerSecondName;

    public void setBookOwnerName(String bookOwnerName) {
        this.bookOwnerName = bookOwnerName;
    }

    public void setBookOwnerSecondName(String bookOwnerSecondName) {
        this.bookOwnerSecondName = bookOwnerSecondName;
    }

    public String getBookOwnerName() {
        return bookOwnerName;
    }

    public String getBookOwnerSecondName() {
        return bookOwnerSecondName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookOwner bookOwner = (BookOwner) o;
        return java.util.Objects.equals(bookOwnerName, bookOwner.bookOwnerName) &&
                java.util.Objects.equals(bookOwnerSecondName, bookOwner.bookOwnerSecondName);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), bookOwnerName, bookOwnerSecondName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "BookOwner{"
                + "id='" + getId()
                + '\''
                + ", bookOwnerName='"
                + bookOwnerName
                + '\''
                + ", bookOwnerSecondName="
                + bookOwnerSecondName
                + '\''
                + '}';
    }
}