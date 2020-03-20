package domain;

import java.io.Serializable;
import java.util.Objects;

public class Book extends AbstractEntity<Long> {

    private String name;
    private String author;
    private String description; // can be empty? needs discussing

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Book{"
                + "id='"
                + getId()
                + '\''
                + ", name='"
                + name
                + '\''
                + ", author="
                + author
                + ", description='"
                + description
                + '\''
                + '}';
    }
}
