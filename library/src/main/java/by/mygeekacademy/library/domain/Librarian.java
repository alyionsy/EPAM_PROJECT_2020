package by.mygeekacademy.library.domain;

import java.util.Objects;

public class Librarian extends AbstractEntity<Integer> {
    private String username;
    private String password;

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
