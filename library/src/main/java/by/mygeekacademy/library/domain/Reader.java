package by.mygeekacademy.library.domain;

import java.io.Serializable;

public class Reader extends AbstractEntity<Integer> {
    private String name;
    private String secondName;

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return java.util.Objects.equals(name, reader.name) &&
                java.util.Objects.equals(secondName, reader.secondName);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, secondName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reader{"
                + "id=" + getId() +
                ", readerName='" + name + '\'' +
                ", readerSecondName='" + secondName + '\'' +
                '}';
    }
}