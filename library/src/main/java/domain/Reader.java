package domain;

import java.io.Serializable;

public class Reader extends AbstractEntity<Integer> implements Serializable {
    private String readerName;
    private String readerSecondName;

//    public Reader(String readerName, String readerSecondName) {
//        this.readerName = readerName;
//        this.readerSecondName = readerSecondName;
//    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setReaderSecondName(String readerSecondName) {
        this.readerSecondName = readerSecondName;
    }

    public String getReaderName() {
        return readerName;
    }

    public String getReaderSecondName() {
        return readerSecondName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return java.util.Objects.equals(readerName, reader.readerName) &&
                java.util.Objects.equals(readerSecondName, reader.readerSecondName);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), readerName, readerSecondName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reader{"
                + "id=" + getId() +
                ", readerName='" + readerName + '\'' +
                ", readerSecondName='" + readerSecondName + '\'' +
                '}';
    }
}