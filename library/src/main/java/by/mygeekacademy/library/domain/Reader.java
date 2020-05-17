package by.mygeekacademy.library.domain;

import javax.persistence.*;

@Entity
@Table(name = "Readers")
public class Reader extends AbstractEntity<Integer> {
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;

    public Reader() {
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

    @Override
    public String toString() {
        return "Reader{"
                + "id=" + getId() +
                ", readerName='" + name + '\'' +
                ", readerSecondName='" + secondName + '\'' +
                '}';
    }
}