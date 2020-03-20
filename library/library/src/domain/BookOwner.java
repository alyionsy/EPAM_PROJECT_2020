package domain;
// we decided to name that class this way
// because name 'reader' is usually used for other types of classes
public class BookOwner extends AbstractEntity<Long> {
    private String username;
    private String password;
    private String bookOwnerName;
    private String bookOwnerSecondName;

    public BookOwner(String username, String password, String bookOwnerName, String bookOwnerSecondName) {
        this.username = username;
        this.password = password;
        this.bookOwnerName = bookOwnerName;
        this.bookOwnerSecondName = bookOwnerSecondName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookOwnerName(String bookOwnerName) {
        this.bookOwnerName = bookOwnerName;
    }

    public void setBookOwnerSecondName(String bookOwnerSecondName) {
        this.bookOwnerSecondName = bookOwnerSecondName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
        return java.util.Objects.equals(username, bookOwner.username) &&
                java.util.Objects.equals(password, bookOwner.password) &&
                java.util.Objects.equals(bookOwnerName, bookOwner.bookOwnerName) &&
                java.util.Objects.equals(bookOwnerSecondName, bookOwner.bookOwnerSecondName);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), username, password, bookOwnerName, bookOwnerSecondName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CarOwner{" +
                "username=" + username +
                ", password=" + password +
                ", bookOwnerName=" + bookOwnerName +
                ", bookOwnerSecondName=" + bookOwnerSecondName +
                '}';
    }
}