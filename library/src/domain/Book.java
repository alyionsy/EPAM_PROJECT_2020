package domain;

import java.io.Serializable;
import java.util.Objects;

public class Book extends AbstractEntity<Long> implements Serializable {

    private String name;
    private String author;
    private String description; // can be empty? needs discussing
    private boolean status; // 'true' means 'is available'

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return author;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, author);
    }

    @Override
    public String toString() {
        String strStatus;
        if (status) {
            strStatus = "available";
        }
        else {
            strStatus = "unavailable";
        }
        return "Book{"
                + "id='"
                + getId()
                + '\''
                + ", name='"
                + name
                + '\''
                + ", author="
                + author
                + ", discription='"
                + description
                + '\''
                + ", status='"
                + strStatus
                + '\''
                + '}';
    }
}
