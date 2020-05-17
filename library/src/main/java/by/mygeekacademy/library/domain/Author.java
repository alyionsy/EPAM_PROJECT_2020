package by.mygeekacademy.library.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Authors")
public class Author extends AbstractEntity<Integer> {
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;

    public Author() {
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(secondName, author.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, secondName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Author{id=").append(getId()).append(", name='").append(name).append('\'');
        if (secondName != null) {
            sb.append(", secondName='").append(secondName).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}
