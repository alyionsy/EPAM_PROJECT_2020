package domain;

import java.util.Objects;

public class Author extends AbstractEntity<Integer> {
    private String name;
    private String secondName;

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
        sb.append("Author{" + "name='").append(name).append('\'');
        if (secondName != null) {
            sb.append(", secondName='").append(secondName).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}
