package by.mygeekacademy.library.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Librarians")
public class Librarian extends AbstractEntity<Integer> {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Librarian() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(username, librarian.username) &&
                Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
