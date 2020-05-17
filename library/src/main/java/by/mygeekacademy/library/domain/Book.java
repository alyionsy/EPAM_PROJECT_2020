package by.mygeekacademy.library.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Books")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(nullable = false, unique = true, updatable = false)) })
public class Book extends AbstractEntity<Integer> {
    @Column(name = "name")
    private String name;
    @Column(name = "authorID")
    private int authorID;
    @Column(name = "year")
    private int year;
    @Column(name = "description")
    private String description;

    public Book() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int id) {
        this.authorID = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return authorID == book.authorID &&
                year == book.year &&
                Objects.equals(name, book.name) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, authorID, year, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", authorID=" + authorID +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
